package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.BookEntity;
import com.sedbproj.Railways.Errors.DuplicatedBookException;
import com.sedbproj.Railways.Repositories.BookRepository;
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
    RouteService routeService;
    //TODO think about return types
    public void createBook(BookInfo bookInfo, Long passengerSsn, Integer routeId, Integer arriveStationId, Integer departureStationId) throws RuntimeException{
        boolean checkExistence = bookRepository.existsBookEntityByRouteIdAndArriveStationIdAndDepartStationId1AndCarriageIdAndSeatNumAndSsn(
                routeId,
                arriveStationId,
                departureStationId,
                bookInfo.getCarriageId(),
                bookInfo.getSeatNum(),
                passengerSsn
        );

        if(!checkExistence) {
            BookEntity bookEntity = new BookEntity(
                    routeId,
                    arriveStationId,
                    departureStationId,
                    bookInfo.getCarriageId(), bookInfo.getSeatNum(),
                    passengerSsn,
                    bookInfo.getPrice(),
                    bookInfo.getAdult()
            );
            bookRepository.save(bookEntity);
        }else  {
            throw new DuplicatedBookException();
        }
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
}
