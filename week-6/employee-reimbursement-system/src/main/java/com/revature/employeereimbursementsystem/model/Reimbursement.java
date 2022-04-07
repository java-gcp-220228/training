package com.revature.employeereimbursementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="ers_reimbursement")
@NoArgsConstructor @Getter @Setter @ToString
public class Reimbursement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="reimbursement_amount")
    private double amount;

    @Column(name="reimbursement_description")
    private String description;

    @Column(name="reimbursement_submitted_datetime")
    private LocalDateTime submitted;

    @Column(name="reimbursement_resolved_datetime")
    private LocalDateTime resolved;

    @ManyToOne
    private User author;

    @ManyToOne
    private User resolver;

    @ManyToOne
    private ReimbursementStatus status;

    @ManyToOne
    private ReimbursementType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(description, that.description) && Objects.equals(submitted, that.submitted) && Objects.equals(resolved, that.resolved) && Objects.equals(author, that.author) && Objects.equals(resolver, that.resolver) && Objects.equals(status, that.status) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, description, submitted, resolved, author, resolver, status, type);
    }
}
