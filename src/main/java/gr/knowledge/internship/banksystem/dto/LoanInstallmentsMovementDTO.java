package gr.knowledge.internship.banksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanInstallmentsMovementDTO {
    private Long id;
    private MovementDTO movement;
    //  private Loan loan;
}
