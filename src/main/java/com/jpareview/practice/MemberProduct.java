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

    public MemberPrac getMember() {
        return member;
    }

    public void setMember(MemberPrac member) {
        this.member = member;
    }

    public ProductPrac getProduct() {
        return product;
    }

    public void setProduct(ProductPrac product) {
        this.product = product;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
