package ru.shevchenkov.newsmicroservice.controllers;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.shevchenkov.newsmicroservice.model.News;
import ru.shevchenkov.newsmicroservice.repositories.NewsRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsRepo newsRepo;
    @Autowired
    News news;


    @GetMapping
    public List<News> getAllNews() {
        return (List<News>) newsRepo.findAllById();
    }

    @GetMapping("{id}")
    public Optional<News> getOneNews(@PathVariable("id") Long id) {
        return newsRepo.findById(id);
    }

    @PostMapping
    public News createNews(@RequestBody News news) {
        news.setDate(LocalDateTime.now());
        return newsRepo.save(news);
    }

    @PutMapping("{id}")
    public News updateDocument(@PathVariable("id") News news,
                               @RequestBody News updatedNews) {
        BeanUtils.copyProperties(updatedNews, news, "id");
        return newsRepo.save(news);
    }

    @DeleteMapping("{id}")
    public void deleteNews(@PathVariable("id") Long id){
        newsRepo.deleteById(id);
    }


}
