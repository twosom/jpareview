package review;

import javax.persistence.*;

@Entity
public class MemberPrac {

    @Id
    @Column(name = "MEMBER_PRAC_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_PRAC_ID", nullable = false)
    private TeamPrac teamPrac;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TeamPrac getTeamPrac() {
        return teamPrac;
    }

    public void setTeamPrac(TeamPrac teamPrac) {
        this.teamPrac = teamPrac;
    }
}
