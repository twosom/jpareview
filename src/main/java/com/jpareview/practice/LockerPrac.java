package com.jpareview.practice;

import javax.persistence.*;

@Entity
public class LockerPrac {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCKER_PRAC_ID")
    private Long id;

    private String name;


    @OneToOne
    @JoinColumn(name = "MEMBER_PRAC_ID")
    private MemberPrac member;


}
