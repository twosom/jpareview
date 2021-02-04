package com.jpareview.practice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductPrac {

    @Id
    @Column(name = "PRODUCT_PRAC_ID")
    private String id;

    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
