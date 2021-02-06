package review.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamEx {

    @Id
    @Column(name = "TEAM_EX_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "teamEx")
    private List<MemberEx> memberExList = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberEx> getMemberExList() {
        return memberExList;
    }

    public void setMemberExList(List<MemberEx> memberExList) {
        this.memberExList = memberExList;
    }
}
