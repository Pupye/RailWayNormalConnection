package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.BookEntity;
import com.sedbproj.Railways.Errors.DuplicatedBookException;
import com.sedbproj.Railways.Repositories.BookRepository;
import com.sedbproj.Railways.Wrappers.bookWrappers.BookCancel;
import com.sedbproj.Railways.Wrappers.bookWrappers.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
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
}
