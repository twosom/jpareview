package com.jpareview.practice;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//상속 매핑은 부모 클래스에 @Inheritance를 사용해야 한다. 매핑 전략을 지정해야 하는데 여기서는 JOINED 전략 사용.
@DiscriminatorColumn(name = "DTYPE")
//부모 클래스에 구분 컬럼을 지정한다. 이 컬럼으로 지정된 자식 테이블을 구분할 수 있다. 기본값이  ㅇ쑈ㅖㄸdlamfh @DiscriminatorColumn으로 줄여 사용해도 된다.
public class ItemPrac {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_PRAC_ID")
    private Long id;

    private String name;
    private int price;


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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

