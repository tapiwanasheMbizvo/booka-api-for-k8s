package com.tmgreyhat.spring.postgres.docker.kube.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{


}
