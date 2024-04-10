package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "loan")
public class Loan implements Serializable {
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
    @ManyToOne
    @JoinColumn(name="applicant_id")
    private Applicant applicant;

    @NotNull
    @ManyToOne
    @JoinColumn(name="bank_registry_id")
    private BankRegistry bankRegistry;

    @Column(name="months")
    private Integer months;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="interest_rate")
    private BigDecimal interestRate;

    @Column(name="nominal_amount")
    private BigDecimal nominalAmount;

    @ManyToOne
    @NotNull
    @JoinColumn(name="loan_status")
    private CodedType loanStatus;
}
