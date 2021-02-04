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


    //역방향
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts;


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

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct> memberProducts) {
        this.memberProducts = memberProducts;
    }

    public LockerPrac getLocker() {
        return locker;
    }

    public void setLocker(LockerPrac locker) {
        this.locker = locker;
    }


}
