package com.jpareview.practice;

import java.io.Serializable;
import java.util.Objects;

public class ParentId implements Serializable {

    private String id1; //Parent.id1과 매핑

    private String id2; //Parent.id2와 매핑


    public ParentId() {
    }

    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParentId parentId = (ParentId) o;

        if (!Objects.equals(id1, parentId.id1)) return false;
        return Objects.equals(id2, parentId.id2);
    }

    @Override
    public int hashCode() {
        int result = id1 != null ? id1.hashCode() : 0;
        result = 31 * result + (id2 != null ? id2.hashCode() : 0);
        return result;
    }
}
