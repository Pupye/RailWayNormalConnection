package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
