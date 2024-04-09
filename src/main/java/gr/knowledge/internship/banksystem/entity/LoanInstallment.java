package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoanInstallment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_installment_id_seq")
    @SequenceGenerator(name = "loan_installment_id_seq", sequenceName = "loan_installment_id_seq", allocationSize = 50, initialValue = 1)
    @NotNull
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="loan_id")
    private Loan loan;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="intrest_amount")
    private float interestAmount;

    @Column(name="capital_amount")
    private float capitalAmount;

    @Column(name="balance_of_interest_amount")
    private float balanceOfInterestAmount;

    @Column(name="balance_of_capital_amount")
    private float balanceOfCapitalAmount;



}
