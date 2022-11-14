package com.tmgreyhat.spring.postgres.docker.kube.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long bookID;
    private String bookName;
    private  String authorName;

}
