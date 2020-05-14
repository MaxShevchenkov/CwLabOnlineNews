package ru.shevchenkov.newsmicroservice.repositories;

import antlr.collections.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.shevchenkov.newsmicroservice.model.News;

import java.util.Collection;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface NewsRepo extends JpaRepository<News, Long> {

    @Query("select n from News n order by n.id desc")
    Collection<News>findAllById();
}
