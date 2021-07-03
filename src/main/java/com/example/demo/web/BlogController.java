package com.example.demo.web;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = {"/blogs"},
        produces = MediaType.APPLICATION_JSON_VALUE
)

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping()
    public List<Blog> getPeople(){
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable Long id){
        return this.blogService.findById(id);
    }

    @PostMapping("/add")
    public List<Blog> addPerson(@RequestBody Blog blog){
        return blogService.addBlog(blog);
    }

    @PutMapping("/edit/{id}")
    public List<Blog> editPerson(@PathVariable Long id,@RequestBody Blog blog){
        return blogService.updateBlog(id,blog);
    }

    @DeleteMapping("/delete/{id}")
    public List<Blog> deletePerson(@PathVariable Long id){
        return blogService.deleteBlog(id);
    }
}
