package com.example.demo.model;


import lombok.Getter;
import javax.validation.constraints.*;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "BLOG")
public class Blog extends AbstractId{

    @Column(name = "TITLE")
    @NotNull
    @Min(value = 2,message = "Title must be at least 2 characters long!")
    private String title;
    @Column(name = "DESCRIPTION")
    // @Size(max = 200000)
    @Lob
    private String description;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "POSTTIME")
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime postTime = LocalDateTime.now();

    public Blog() {

    }

    public Blog(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }
}

