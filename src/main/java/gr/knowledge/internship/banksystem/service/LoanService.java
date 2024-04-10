package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.mapper.LoanMapper;
import gr.knowledge.internship.banksystem.dto.LoanDTO;
import gr.knowledge.internship.banksystem.entity.Loan;
import gr.knowledge.internship.banksystem.repository.LoanRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
/**
 * Service class for managing Loans.
 */
@Service
@Transactional
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanMapper loanMapper;

    /**
     * Retrieves all Loans from the repository and maps them to DTOs.
     * @return a list of LoanDto objects.
     */
    @Transactional(readOnly = true)
    public List<LoanDTO> getAllLoans() {
        List<Loan> loanList = loanRepository.findAll();
        return loanMapper.toDtoList(loanList);
    }
    /**
     * Retrieves a Loan by its ID from the repository and maps it to a DTO.
     * @param id the ID of the Loan to retrieve.
     * @return a LoanDto object.
     */
    @Transactional(readOnly = true)
    public LoanDTO getLoanById(Long id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        return loanMapper.toDto(loan);
    }
    /**
     * Saves a new Loan to the repository.
     * @param loanDto the LoanDto to save.
     * @return the saved LoanDto.
     */
    public LoanDTO saveLoan(LoanDTO loanDto) {
        loanRepository.save(loanMapper.toEntity(loanDto));
        return loanDto;
    }
    /**
     * Updates an existing Loan in the repository, if exists.
     * @param loanDto the LoanDto to update.
     * @param id the ID of the Loan to update.
     * @return the updated LoanDto.
     */
    public LoanDTO updateLoan(LoanDTO loanDto, Long id) {
        checkExistingLoan(loanDto, id);
        loanRepository.save(loanMapper.toEntity(loanDto));
        return loanDto;
    }
    /**
     * Checks if a Loan with the given ID exists in the repository.
     * If the Loan does not exist, it throws an IllegalArgumentException.
     * If the ID in the LoanDto does not match the provided ID, it also throws an IllegalArgumentException.
     * @param loanDto the LoanDto containing the ID to check.
     * @param id the ID to compare with the ID in the LoanDto.
     * @throws IllegalArgumentException if there is no Loan with the given ID or if the IDs do not match.
     */
    private void checkExistingLoan(LoanDTO loanDto, Long id) {
        if (loanRepository.findById(loanDto.getId()).isEmpty()){
            throw new IllegalArgumentException("There is no Loan with ID: "+loanDto.getId());
        }
        else if (!loanDto.getId().equals(id)){
            throw new IllegalArgumentException("ID in Path doesn't match body");
        }
    }
    /**
     * Deletes a Loan from the repository if exists, else throw exception.
     * @param loanDto the LoanDto to delete.
     */
    public void deleteLoan(LoanDTO loanDto) {
        if (loanRepository.findById(loanDto.getId()).isEmpty()){
            throw new IllegalArgumentException("There is no Loan with ID: "+loanDto.getId()+" to delete");
        }
        loanRepository.delete(loanMapper.toEntity(loanDto));
    }
}
