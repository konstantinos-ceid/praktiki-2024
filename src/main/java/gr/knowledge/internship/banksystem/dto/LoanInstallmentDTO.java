package gr.knowledge.internship.banksystem.dto;

import gr.knowledge.internship.banksystem.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanInstallmentDTO implements Serializable {

    private Long id;
    private Loan loan;
    private LocalDate startDate;
    private BigDecimal interestAmount;
    private BigDecimal capitalAmount;
    private BigDecimal balanceOfInterestAmount;
    private BigDecimal balanceOfCapitalAmount;
}