package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_id_seq")
    @SequenceGenerator(name = "loan_id_seq", sequenceName = "loan_id_seq", allocationSize = 50, initialValue = 1)
    @NotNull
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="loan_type")
    private CodedType loanType;

    @NotNull
    @OneToOne
    @JoinColumn(name="applicant_id")
    private Applicant applicant;

    @NotNull
    @ManyToOne
    @JoinColumn(name="bank_registry_id")
    private BankRegistry bankRegistry;

    @Column(name="months")
    private int months;

    @Column(name="amount")
    private float amount;

    @Column(name="interest_rate")
    private float interestRate;

    @Column(name="nominal_amount")
    private float nominalAmount;

    @ManyToOne
    @NotNull
    @JoinColumn(name="loan_status")
    private CodedType loanStatus;
}
