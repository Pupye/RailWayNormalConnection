package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.BookEntity;
import com.sedbproj.Railways.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<BookEntity> getAllBooks(){
        return bookRepository.findAll();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrSaveStation(@RequestBody BookEntity book){
        bookRepository.save(book);
    }
}
