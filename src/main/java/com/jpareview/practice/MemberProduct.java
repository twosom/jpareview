package com.jpareview.practice;

import javax.persistence.*;

@Entity
@IdClass(MemberProductId.class)
public class MemberProduct {

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_PRAC_ID")
    private MemberPrac member;


    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_PRAC_ID")
    private ProductPrac product;

    private int orderAmount;
}
