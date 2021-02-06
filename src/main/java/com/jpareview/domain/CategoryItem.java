package com.jpareview.domain;

import com.jpareview.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY_ITEM")
public class CategoryItem extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public void addCategory(Category category) {
        category.getCategoryItemList().add(this);
        setCategory(category);
    }

    public void addItem(Item item) {
        item.getCategoryItemList().add(this);
        setItem(item);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
