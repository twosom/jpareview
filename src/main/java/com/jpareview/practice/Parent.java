package com.jpareview.practice;

import javax.persistence.*;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne
    @JoinTable(name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"),
            uniqueConstraints = @UniqueConstraint(name = "CHILD_ID_UNIQ", columnNames = {"CHILD_ID"})
    )
    private Child child;
}
