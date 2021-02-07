package com.jpareview.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


    public void addOrder(Order order) {
        if (orders.contains(order)) {
            orders.remove(order);
            System.out.println("멤버 쪽 주문 중복 제거 완료");
        }
        if (order.getMember() == this) {
            order.setMember(null);
            System.out.println("주문 쪽 맴버 중복 제거 완료");
        }
        order.setMember(this);
        orders.add(order);
        System.out.println("추가 완료");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
