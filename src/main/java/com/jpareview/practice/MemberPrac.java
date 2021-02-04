package com.jpareview.practice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberPrac {

    @Id
    @Column(name = "MEMBER_PRAC_ID")
    private String id;

    private String username;

    @OneToOne(mappedBy = "member")
    private LockerPrac locker;


    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT",                     //JoinTable 속성 정리 : @JoinTable.name : 연결 테이블 지정.
            joinColumns = @JoinColumn(name = "MEMBER_PRAC_ID"),                 //@JoinTable.joinColumns : 현재 방향인 회원과 매핑할 조인 컬럼 정보 지정.
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_PRAC_ID")            //@JoinTable,inverseJoinColumns : 반대 방향인 상품과 매핑할 조인 컬럼 정보 지정.
    )
    private List<ProductPrac> products = new ArrayList<ProductPrac>();


    public void addProduct(ProductPrac product) {
        if (!product.getMembers().contains(this)) {
            product.getMembers().add(this);
            System.out.println("Added product - member");
        }

        if (!products.contains(product)) {
            products.add(product);
            System.out.println("Added member - product");
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LockerPrac getLocker() {
        return locker;
    }

    public void setLocker(LockerPrac locker) {
        this.locker = locker;
    }

    public List<ProductPrac> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPrac> products) {
        this.products = products;
    }
}
