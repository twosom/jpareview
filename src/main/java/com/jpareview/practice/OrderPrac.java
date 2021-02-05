package com.jpareview.practice;


import javax.persistence.*;

@Entity
@Table(name = "ORDER_PRAC")
public class OrderPrac {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_PRAC_ID")
    private MemberPrac member;


    @ManyToOne
    @JoinColumn(name = "PRODUCT_PRAC_ID")
    private ProductPrac product;

    private int orderAmount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
