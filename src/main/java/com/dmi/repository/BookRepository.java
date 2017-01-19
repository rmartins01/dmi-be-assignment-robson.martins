package com.dmi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dmi.domain.Book;

/**
 * Repository implementation of Book
 * 
 * @author Robson Martins
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>{

	@Query("select c.id, c.title, c.price, c.link from Book c")
	List<Object[]> getAllBooksWithRestrictedColums();
	
}

