package com.revature.employeereimbursementsystem.model;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="reimb_type")
@NoArgsConstructor @Getter @Setter @ToString
public class ReimbursementType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="reimb_type_id")
    private int id;

    @Column(name="type")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementType that = (ReimbursementType) o;
        return id == that.id && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
