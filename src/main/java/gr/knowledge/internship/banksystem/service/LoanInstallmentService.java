package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.mapper.LoanInstallmentMapper;
import gr.knowledge.internship.banksystem.dto.LoanInstallmentDTO;
import gr.knowledge.internship.banksystem.entity.LoanInstallment;
import gr.knowledge.internship.banksystem.repository.LoanInstallmentRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
