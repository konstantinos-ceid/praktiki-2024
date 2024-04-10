package gr.knowledge.internship.banksystem.dto;

import gr.knowledge.internship.banksystem.entity.BankRegistry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO implements Serializable {

    private Long id;
    private CodedTypeDTO loanType;
    private ApplicantDTO applicant;
    private BankRegistryDTO bankRegistry;
    private Integer months;
    private BigDecimal amount;
    private BigDecimal interestRate;
    private BigDecimal nominalAmount;
    private CodedTypeDTO loanStatus;
}