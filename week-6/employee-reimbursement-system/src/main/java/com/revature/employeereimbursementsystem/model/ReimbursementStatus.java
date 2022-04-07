package com.revature.employeereimbursementsystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="reimb_status")
@NoArgsConstructor @Getter @Setter @ToString
public class ReimbursementStatus {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="reimb_status_id")
    private int id;

    @Column(name="status")
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementStatus that = (ReimbursementStatus) o;
        return id == that.id && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
