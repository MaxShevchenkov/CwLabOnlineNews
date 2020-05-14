package ru.shevchenkov.newsmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.shevchenkov.newsmicroservice.model.News;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface NewsRepo extends JpaRepository<News, Long> {

}
