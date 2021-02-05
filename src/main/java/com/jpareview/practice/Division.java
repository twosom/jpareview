package com.jpareview.practice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "DIVISION_ID"))
public class Division extends BaseEntity {


    @OneToMany(mappedBy = "division")
    private List<Soldier> soldiers = new ArrayList<>();

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }
}
