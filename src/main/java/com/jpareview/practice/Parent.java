package com.jpareview.practice;

import javax.persistence.*;

@Entity
public class Parent {

    @Id
    @Column(name = "PARENT_ID")
    private String id;
    private String name;
}
