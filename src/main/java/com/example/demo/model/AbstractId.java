package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
