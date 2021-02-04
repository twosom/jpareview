package com.jpareview.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime ordderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //연관관계 메소드
    public void setMember(Member member) {
        //이미 연관관계 설정이 되어있다면
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }

        this.member = member;
        //상대 객체(Member클래스)에도 추가해서 객체지향적 메소드 구현
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getOrdderDate() {
        return ordderDate;
    }

    public void setOrdderDate(LocalDateTime ordderDate) {
        this.ordderDate = ordderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
