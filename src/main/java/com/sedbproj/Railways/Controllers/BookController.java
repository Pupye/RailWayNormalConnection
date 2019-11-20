package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.BookEntity;
import com.sedbproj.Railways.Services.BookService;
import com.sedbproj.Railways.Services.PassengerService;
import com.sedbproj.Railways.Wrappers.UserHistory.UserHistoryWrapper;
import com.sedbproj.Railways.Wrappers.bookWrappers.BookCancel;
import com.sedbproj.Railways.Wrappers.bookWrappers.BookWrapper;
import com.sedbproj.Railways.Wrappers.bookWrappers.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println("here??");
        for (Passenger p : book.getPassengers()){
            passengerService.createIfNotExists(p.getPassengerInfo(), p.getSSN());
            bookService.createBook(
                    p.getBookInfo(),
                    p.getSSN(),
                    book.getRouteId(),
                    book.getArrStationId(),
                    book.getDepStationId(),
                    book.getUserId()
            );
        }
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.DELETE)
    public void cancelBook(@RequestBody BookCancel bookCancel)
    {
        bookService.cancelBook(bookCancel);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public List<UserHistoryWrapper> getUsersOrderHistory(@PathVariable("id") Integer id){
        bookService.getOrderHistoryByUserId(id);

        return null;
    }
}
