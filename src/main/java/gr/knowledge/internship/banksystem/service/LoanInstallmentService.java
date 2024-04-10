package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.LoanDTO;
import gr.knowledge.internship.banksystem.entity.Loan;
import gr.knowledge.internship.banksystem.mapper.LoanInstallmentMapper;
import gr.knowledge.internship.banksystem.dto.LoanInstallmentDTO;
import gr.knowledge.internship.banksystem.entity.LoanInstallment;
import gr.knowledge.internship.banksystem.repository.LoanInstallmentRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
/**
 * Service class for managing LoanInstallments.
 */
@Service
@Transactional
public class LoanInstallmentService {

    @Autowired
    private LoanInstallmentRepository loanInstallmentRepository;
    @Autowired
    private LoanInstallmentMapper loanInstallmentMapper;

    /**
     * Retrieves all LoanInstallments from the repository and maps them to DTOs.
     * @return a list of LoanInstallmentDto objects.
     */
    @Transactional(readOnly = true)
    public List<LoanInstallmentDTO> getAllLoanInstallments() {
        List<LoanInstallment> loanInstallmentList = loanInstallmentRepository.findAll();
        return loanInstallmentMapper.toDtoList(loanInstallmentList);
    }
    /**
     * Retrieves a LoanInstallment by its ID from the repository and maps it to a DTO.
     * @param id the ID of the LoanInstallment to retrieve.
     * @return a LoanInstallmentDto object.
     */
    @Transactional(readOnly = true)
    public LoanInstallmentDTO getLoanInstallmentById(Long id) {
        LoanInstallment loanInstallment = loanInstallmentRepository.findById(id).orElse(null);
        return loanInstallmentMapper.toDto(loanInstallment);
    }
    /**
     * Saves a new LoanInstallment to the repository.
     * @param loanInstallmentDto the LoanInstallmentDto to save.
     * @return the saved LoanInstallmentDto.
     */
    public LoanInstallmentDTO saveLoanInstallment(LoanInstallmentDTO loanInstallmentDto) {
        loanInstallmentRepository.save(loanInstallmentMapper.toEntity(loanInstallmentDto));
        return loanInstallmentDto;
    }
    /**
     * Updates an existing LoanInstallment in the repository, if exists.
     * @param loanInstallmentDto the LoanInstallmentDto to update.
     * @param id the ID of the LoanInstallment to update.
     * @return the updated LoanInstallmentDto.
     */
    public LoanInstallmentDTO updateLoanInstallment(LoanInstallmentDTO loanInstallmentDto, Long id) {
        checkExistingLoanInstallment(loanInstallmentDto, id);
        loanInstallmentRepository.save(loanInstallmentMapper.toEntity(loanInstallmentDto));
        return loanInstallmentDto;
    }
    /**
     * Checks if a LoanInstallment with the given ID exists in the repository.
     * If the LoanInstallment does not exist, it throws an IllegalArgumentException.
     * If the ID in the LoanInstallmentDto does not match the provided ID, it also throws an IllegalArgumentException.
     * @param loanInstallmentDto the LoanInstallmentDto containing the ID to check.
     * @param id the ID to compare with the ID in the LoanInstallmentDto.
     * @throws IllegalArgumentException if there is no LoanInstallment with the given ID or if the IDs do not match.
     */
    private void checkExistingLoanInstallment(LoanInstallmentDTO loanInstallmentDto, Long id) {
        if (loanInstallmentRepository.findById(loanInstallmentDto.getId()).isEmpty()){
            throw new IllegalArgumentException("There is no LoanInstallment with ID: "+loanInstallmentDto.getId());
        }
        else if (!loanInstallmentDto.getId().equals(id)){
            throw new IllegalArgumentException("ID in Path doesn't match body");
        }
    }
    /**
     * Deletes a LoanInstallment from the repository if exists, else throw exception.
     * @param loanInstallmentDto the LoanInstallmentDto to delete.
     */
    public void deleteLoanInstallment(LoanInstallmentDTO loanInstallmentDto) {
        if (loanInstallmentRepository.findById(loanInstallmentDto.getId()).isEmpty()){
            throw new IllegalArgumentException("There is no LoanInstallment with ID: "+loanInstallmentDto.getId()+" to delete");
        }
        loanInstallmentRepository.delete(loanInstallmentMapper.toEntity(loanInstallmentDto));
    }

    /**
     * Calculates the monthly annuity(Installment) payment for a loan. The formula used is: P = [r*PV] / [1 - (1 + r)^-n]
     * @param loanAmount is the present value, or the total amount of the loan (PV)
     * @param interestRate is the interest rate per period (monthly interest rate in this case) (r)
     * @param totalMonths is the total number of payments (or periods) (n)
     * @return the annuity payment (P)
     */
    private BigDecimal calculateMonthlyAnnuity(BigDecimal loanAmount, BigDecimal interestRate, int totalMonths) {

        BigDecimal denominator = BigDecimal.ONE.subtract(BigDecimal.ONE.divide((BigDecimal.ONE.add(interestRate)).pow(totalMonths), 8, RoundingMode.HALF_UP));
        return loanAmount.multiply(interestRate).divide(denominator, 2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the interest part of the annuity payment for a specific period using the formula: Interest = Outstanding Loan Balance * Monthly Interest Rate
     * @param annuityBalance The outstanding loan balance before the payment
     * @param monthlyInterestRate The monthly interest rate
     * @return The interest part of the annuity payment
     */
    private BigDecimal calculateInterestPart(BigDecimal annuityBalance, BigDecimal monthlyInterestRate) {
        return annuityBalance.multiply(monthlyInterestRate);
    }

    /**
     * Calculates the principal part of the annuity payment for a specific period using the formula: Principal = Total Monthly Payment - Interest
     * @param totalMonthlyPayment The total monthly payment (annuity)
     * @param interestPart The interest part of the payment
     * @return The principal part of the annuity payment
     */
    private BigDecimal calculateCapitalPart(BigDecimal totalMonthlyPayment, BigDecimal interestPart) {
        return totalMonthlyPayment.subtract(interestPart);
    }

    /**
     * Creates loan installments for a given loan. Each installment includes the interest and principal parts of the annuity payment.
     * @param loan The loan for which to create installments
     */
    public void createLoanInstallments(Loan loan) {
        BigDecimal totalMonthlyPayment = calculateMonthlyAnnuity(loan.getNominalAmount(), loan.getInterestRate(), loan.getMonths());
        for (int i = 1; i <= loan.getMonths(); i++) {
            BigDecimal interestPart = calculateInterestPart(totalMonthlyPayment, loan.getInterestRate());
            BigDecimal capitalPart = calculateCapitalPart(totalMonthlyPayment, interestPart);

            LoanInstallmentDTO loanInstallmentDto = new LoanInstallmentDTO();
            loanInstallmentDto.setLoan(loan);
            loanInstallmentDto.setStartDate(LocalDate.now().plusMonths(i));
            loanInstallmentDto.setInterestAmount(interestPart);
            loanInstallmentDto.setCapitalAmount(capitalPart);
            loanInstallmentDto.setBalanceOfInterestAmount(interestPart);
            loanInstallmentDto.setBalanceOfCapitalAmount(capitalPart);
            saveLoanInstallment(loanInstallmentDto);
        }
    }
}
