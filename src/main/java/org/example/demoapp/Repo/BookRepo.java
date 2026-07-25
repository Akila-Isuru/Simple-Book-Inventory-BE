package org.example.demoapp.Repo;

import org.example.demoapp.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {


}
