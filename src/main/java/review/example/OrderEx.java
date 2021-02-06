package review.example;

import javax.persistence.*;

@Entity
public class OrderEx {

    @Id
    @Column(name = "ORDER_EX_ID")
    private String id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_EX_ID")
    private MemberEx memberEx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_EX_ID")
    private ProductEx productEx;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MemberEx getMemberEx() {
        return memberEx;
    }

    public void setMemberEx(MemberEx memberEx) {
        this.memberEx = memberEx;
    }

    public ProductEx getProductEx() {
        return productEx;
    }

    public void setProductEx(ProductEx productEx) {
        this.productEx = productEx;
    }
}
