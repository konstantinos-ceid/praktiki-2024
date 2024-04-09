package gr.knowledge.internship.banksystem.dto;

import gr.knowledge.internship.banksystem.entity.BankRegistry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO implements Serializable {

    private Long id;
    private CodedTypeDTO loanType;
    private ApplicantDTO applicantDTO;
    private BankRegistry bankRegistry;
    private int months;
    private float amount;
    private float interestRate;
    private float nominalAmount;
    private CodedTypeDTO loanStatus;
}