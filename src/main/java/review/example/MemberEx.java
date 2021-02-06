package review.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberEx {

    @Id
    @Column(name = "MEMBER_EX_ID")
    private String id;

    private String username;
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_EX_ID", nullable = false)  //not null을 사용해서 innerJoin을 사용하려고.
    private TeamEx teamEx;


    @OneToMany(mappedBy = "memberEx", fetch = FetchType.LAZY)
    private List<OrderEx> orderExList = new ArrayList<>();

    public void addOrder(OrderEx orderEx) {
        orderEx.setMemberEx(this);
        orderExList.add(orderEx);
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public TeamEx getTeamEx() {
        return teamEx;
    }

    public void setTeamEx(TeamEx teamEx) {
        this.teamEx = teamEx;
    }

    public List<OrderEx> getOrderExList() {
        return orderExList;
    }

    public void setOrderExList(List<OrderEx> orderExList) {
        this.orderExList = orderExList;
    }
}
