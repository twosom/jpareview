package com.jpareview.practice;


import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
public class Child {

    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;


    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }
}
