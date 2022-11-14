package com.tmgreyhat.spring.postgres.docker.kube.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1/books")
public class BookController {


    private  final  BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){


        return  ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Book> getOneBook(@PathVariable Long id){


        return  ResponseEntity.ok().body(bookService.getOneBook(id).get());

    }

    @PostMapping
    public  ResponseEntity<Book> saveOneBook(@RequestBody Book book){

        return  ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));

    }
}
