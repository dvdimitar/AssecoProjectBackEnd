package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    List<Blog> addBlog(Blog blog);
    Blog findById(Long id);
    List<Blog> updateBlog (Long id,Blog blog);
    List<Blog> deleteBlog(Long id);
}
