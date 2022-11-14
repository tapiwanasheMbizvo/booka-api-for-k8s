package com.tmgreyhat.spring.postgres.docker.kube.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final  BookRepository bookRepository;

    public List<Book> getAllBooks(){

        return  bookRepository.findAll();
    }

    public Optional<Book> getOneBook(long bookId){

        return  bookRepository.findById(bookId);
    }

    public Book saveBook(Book book){

        return  bookRepository.save(book);
    }

    public  void deleteBook(long bookID){

         bookRepository.deleteById(bookID);
    }

    public Book updateBookDetails(Book book){


        return  bookRepository.save(book);
    }
}
