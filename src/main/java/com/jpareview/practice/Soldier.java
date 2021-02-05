package com.jpareview.practice;


import javax.persistence.*;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "SOLDIER_ID"))
public class Soldier extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "DIVISION_ID")
    private Division division;

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
