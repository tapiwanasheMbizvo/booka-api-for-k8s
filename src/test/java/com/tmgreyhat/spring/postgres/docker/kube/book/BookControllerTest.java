/*
package com.tmgreyhat.spring.postgres.docker.kube.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

class BookControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private  BookRepository repository;

    @Test
    void saveOneBook() throws Exception {


        String bookName = "SomeTestBookName";
        Book book = new Book();
        book.setBookName(bookName);
        book.setAuthorName("SomeAuthor");

        ObjectMapper objectMapper = new ObjectMapper();

        String request =objectMapper.writeValueAsString(book);
        mockMvc.perform(post("/api/v1/books", request)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                 .andExpect(jsonPath("$.success", is(true)))
                .andExpect()


    }
}*/
