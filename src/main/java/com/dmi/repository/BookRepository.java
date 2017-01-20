package com.dmi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dmi.domain.Book;
import com.dmi.domain.BookBase;

/**
 * Repository implementation of Book
 * 
 * @author Robson Martins
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>{

	@Query("select new com.dmi.domain.BookBase(c.id, c.title, c.price, c.link) from Book c")
	List<BookBase> getAllBooksWithRestrictedColums();
	
}

