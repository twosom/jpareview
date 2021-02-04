package com.jpareview.practice;

import java.io.Serializable;
import java.util.Objects;

public class MemberProductId implements Serializable {

    private String member;  //MemberProduct.member와 연결
    private String product; //MemberProduct,product와 연결

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    //hashCode and equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberProductId that = (MemberProductId) o;

        if (!Objects.equals(member, that.member)) return false;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        int result = member != null ? member.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
