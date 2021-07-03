package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.model.exception.SameTitleException;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.BlogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogServiceImplementation implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImplementation(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public List<Blog> addBlog(Blog blog) {
        List<Blog> blogs = this.findAll();
        for (Blog bg : blogs) {
            if (bg.getTitle().equals(blog.getTitle())) {
                throw new SameTitleException(bg.getTitle());
            }
        }
                this.blogRepository.save(blog);
                return this.findAll();
            }


    @Override
    public List<Blog> updateBlog(Long id,Blog blog) {
        List<Blog> blogs = this.findAll();
        Blog oldBlog = this.findById(id);
        for (Blog bg : blogs) {
            if (!oldBlog.getId().equals(bg.getId())) {
                if (bg.getTitle().equals(blog.getTitle())) {
                    throw new SameTitleException(bg.getTitle());
                }
            }
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setDescription(blog.getDescription());
        oldBlog.setAuthor(blog.getAuthor());
        oldBlog.setPostTime(LocalDateTime.now());
        this.blogRepository.save(oldBlog);
        return this.findAll();
    }

    public Blog findById(Long id){
        return this.blogRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Blog> deleteBlog(Long id) {
      this.blogRepository.deleteById(id);
      return this.findAll();
    }
}
