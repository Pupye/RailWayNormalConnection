package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.BookEntity;
import com.sedbproj.Railways.Entities.PassengerEntity;
import com.sedbproj.Railways.Entities.StationEntity;
import com.sedbproj.Railways.Errors.DuplicatedBookException;
import com.sedbproj.Railways.Repositories.BookRepository;
import com.sedbproj.Railways.Repositories.CarriageRepository;
import com.sedbproj.Railways.Repositories.PassengerRepository;
import com.sedbproj.Railways.Repositories.StationRepository;
import com.sedbproj.Railways.Wrappers.UserHistory.PassengerHistoryWrapper;
import com.sedbproj.Railways.Wrappers.UserHistory.UserHistoryWrapper;
import com.sedbproj.Railways.Wrappers.bookWrappers.BookCancel;
import com.sedbproj.Railways.Wrappers.bookWrappers.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    StationRepository stationRepository;

    @Autowired
    CarriageRepository carriageRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    RouteService routeService;
    //TODO think about return types
    public void createBook(BookInfo bookInfo, Long passengerSsn, Integer routeId, Integer arriveStationId, Integer departureStationId, Integer userId) throws RuntimeException{

            BookEntity bookEntity = new BookEntity(
                    routeId,
                    arriveStationId,
                    departureStationId,
                    bookInfo.getCarriageId(), bookInfo.getSeatNum(),
                    passengerSsn,
                    bookInfo.getPrice(),
                    bookInfo.getAdult(),
                    userId
            );
            bookRepository.save(bookEntity);
    }

    public void cancelBook(BookCancel bookCancel) {
        bookRepository.deleteByCancelJson(
                bookCancel.getRouteID(),
                bookCancel.getDepartStationID(),
                bookCancel.getArriveStationID(),
                bookCancel.getCarriageID(),
                bookCancel.getSeatNum(),
                bookCancel.getSSN()
        );
    }

    public List<Integer> getBookedSeats(Integer routeId, Integer arriveStationId, Integer departureStationId, Integer carriageID){
        List<Integer> result = new ArrayList<>();

        Integer arriveSearchOrder = routeService.getOrderByRouteAndStationId(routeId, departureStationId);
        Integer departureSearchOrder = routeService.getOrderByRouteAndStationId(routeId, arriveStationId);
        List<BookEntity> bookEntities = bookRepository.findBookEntitiesByRouteIdAndCarriageId(routeId, carriageID);

        for (BookEntity book : bookEntities){
            Integer booksArrivalOrder = routeService.getOrderByRouteAndStationId(routeId, book.getArriveStationId());
            Integer booksDepartureOrder = routeService.getOrderByRouteAndStationId(routeId, book.getDepartStationId1());
            boolean isRangeFromUp = booksDepartureOrder >= arriveSearchOrder;
            boolean isRangeFromDown = booksArrivalOrder <= departureSearchOrder;

            if (!isRangeFromDown && !isRangeFromUp){
                result.add(book.getSeatNum());
            }

        }
        return result;
    }

    public List<BookEntity> getOrderHistoryByUserId(Integer userId){
        return bookRepository.findBookEntitiesByUserIdOrderByRouteId(userId);
    }

    public List<UserHistoryWrapper> getUserHistoryWrapperById(Integer userId){
        List<BookEntity> bookEntities = getOrderHistoryByUserId(userId); // this thing is ordered by routeId
        if (bookEntities.size()==0){
            return new ArrayList<>();
        }
        List<PassengerHistoryWrapper> passengerHistoryWrappers = new ArrayList<>();
        List<UserHistoryWrapper> userHistoryWrapperList = new ArrayList<>();
        UserHistoryWrapper userHistoryWrapper = null;
        int trainId = 0;
        int routeId = 0;
        int current = -1;

        for (BookEntity book : bookEntities) {
            if (current == -1){
                routeId = book.getRouteId();
                current = routeId;
                trainId = routeService.getTrainIdByRouteId(routeId);
                userHistoryWrapper = getUserHistoryWrapper(passengerHistoryWrappers, trainId, routeId, book);
                userHistoryWrapperList.add(userHistoryWrapper);
            }else if (current != book.getRouteId()){
                userHistoryWrapper.setPassangers(passengerHistoryWrappers);
                passengerHistoryWrappers = new ArrayList<>();
                routeId = book.getRouteId();
                current = routeId;
                trainId = routeService.getTrainIdByRouteId(routeId);
                userHistoryWrapper = getUserHistoryWrapper(passengerHistoryWrappers, trainId, routeId, book);
                userHistoryWrapperList.add(userHistoryWrapper);
            }else{
                PassengerEntity passenger = passengerRepository.findPassengerEntityBySsn(book.getSsn());
                passengerHistoryWrappers.add(
                        new PassengerHistoryWrapper(
                                passenger.getFname(),
                                passenger.getLname(),
                                passenger.getSsn(),
                                book.getSeatNum(),
                                book.getCarriageId(),
                                carriageRepository.getTypeByCarriageIdAndTrainId(book.getCarriageId(), trainId),
                                book.getPrice()
                        )
                );
            }

        }
        if( userHistoryWrapperList.get(userHistoryWrapperList.size()-1).getPassangers()==null){
            userHistoryWrapperList.get(userHistoryWrapperList.size()-1).setPassangers(passengerHistoryWrappers);
        }
        return userHistoryWrapperList;
    }

    private UserHistoryWrapper getUserHistoryWrapper(List<PassengerHistoryWrapper> passengerHistoryWrappers, int trainId, int routeId, BookEntity book) {
        UserHistoryWrapper userHistoryWrapper;
        String departureTime = routeService.getDepartureTimeByRouteIdAndStationId(routeId, book.getDepartStationId1());
        String arrivalTime = routeService.getArrivalTimeByRouteIdAndStationId(routeId, book.getArriveStationId());
        StationEntity arrStation = stationRepository.findByStationId(book.getArriveStationId());
        StationEntity depStation = stationRepository.findByStationId(book.getDepartStationId1());
        userHistoryWrapper = new UserHistoryWrapper(
            trainId, routeId, departureTime, arrivalTime, arrStation.getName(), arrStation.getCity(), depStation.getName(), depStation.getCity()
        );

        PassengerEntity passenger = passengerRepository.findPassengerEntityBySsn(book.getSsn());
        passengerHistoryWrappers.add(
                new PassengerHistoryWrapper(
                        passenger.getFname(),
                        passenger.getLname(),
                        passenger.getSsn(),
                        book.getSeatNum(),
                        book.getCarriageId(),
                        carriageRepository.getTypeByCarriageIdAndTrainId(book.getCarriageId(), trainId),
                        book.getPrice()
                )
                );
        return userHistoryWrapper;
    }
}
