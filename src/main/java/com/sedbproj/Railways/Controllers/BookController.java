package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Services.BookService;
import com.sedbproj.Railways.Services.PassengerService;
import com.sedbproj.Railways.Wrappers.bookWrappers.BookCancel;
import com.sedbproj.Railways.Wrappers.bookWrappers.BookWrapper;
import com.sedbproj.Railways.Wrappers.bookWrappers.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    PassengerService passengerService;

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void bookSeats(@RequestBody BookWrapper book) {
        for (Passenger p : book.getPassengers()){
            passengerService.createIfNotExists(p.getPassengerInfo(), p.getSSN());
            bookService.createBook(
                    p.getBookInfo(),
                    p.getSSN(),
                    book.getRouteId(),
                    book.getArrStationId(),
                    book.getDepStationId()
            );
        }
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.DELETE)
    public void cancelBook(@RequestBody BookCancel bookCancel)
    {
        bookService.cancelBook(bookCancel);

    }
}
