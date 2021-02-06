package com.jpareview.practice;


import javax.persistence.*;

@Entity
public class Child {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    @OneToOne(mappedBy = "child")
    private Parent parent;



    private String name;
}
