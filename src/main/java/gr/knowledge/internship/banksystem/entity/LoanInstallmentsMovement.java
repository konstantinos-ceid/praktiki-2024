package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanInstallmentsMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_loan_installments_movement")
    @SequenceGenerator(name="seq_loan_installments_movement", sequenceName="seq_loan_installments_movement", allocationSize=50, initialValue = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movement_id", referencedColumnName = "id")
    private Movement movement;

   // @ManyToOne
 //   @JoinColumn(name = "loan_id", referencedColumnName = "id")
  //  private Loan loan;

}
