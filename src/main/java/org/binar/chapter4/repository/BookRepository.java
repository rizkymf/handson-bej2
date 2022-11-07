package org.binar.chapter4.repository;

import org.binar.chapter4.model.Book;
import org.binar.chapter4.model.BookId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, BookId> {

    @Query(nativeQuery = true, value = "select * from book")
    public List<Book> findAllBook(Pageable pageable);

//    public List<Book> find
}
