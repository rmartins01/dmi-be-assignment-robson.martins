package com.dmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmi.domain.Book;

/**
 * Repository implementation of Book
 * 
 * @author Robson Martins
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>{

}
