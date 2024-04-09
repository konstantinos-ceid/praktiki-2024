package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.LoanInstallmentsMovementDTO;
import gr.knowledge.internship.banksystem.entity.LoanInstallmentsMovement;
import gr.knowledge.internship.banksystem.mapper.LoanInstallmentsMovementMapper;
import gr.knowledge.internship.banksystem.repository.LoanInstallmentsMovementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service class for managing loan installment movements.
 */
@Service
@Transactional
public class LoanInstallmentsMovementService {

    @Autowired
    private LoanInstallmentsMovementRepository loanInstallmentsMovementRepository;

    @Autowired
    private LoanInstallmentsMovementMapper loanInstallmentsMovementMapper;
    /**
     * Retrieves a list of all loan installment movements.
     *
     * @return List of LoanInstallmentsMovementDTO objects
     */
    @Transactional(readOnly = true)
    public List<LoanInstallmentsMovementDTO> getLoanInstallmentsMovements() {
        return loanInstallmentsMovementMapper.toDTOList(loanInstallmentsMovementRepository.findAll());
    }
    /**
     * Saves a new loan installment movement.
     *
     * @param loanInstallmentsMovementDTO The DTO representing the loan installment movement to be saved
     * @return The saved LoanInstallmentsMovementDTO object
     */
    public LoanInstallmentsMovementDTO saveLoanInstallmentsMovement(LoanInstallmentsMovementDTO loanInstallmentsMovementDTO) {
        return loanInstallmentsMovementMapper.toDTO(loanInstallmentsMovementRepository.save(loanInstallmentsMovementMapper.toEntity(loanInstallmentsMovementDTO)));
    }
    /**
     * Deletes a loan installment movement.
     *
     * @param loanInstallmentsMovementDTO The DTO representing the loan installment movement to be deleted
     */
    public void deleteLoanInstallmentsMovement(LoanInstallmentsMovementDTO loanInstallmentsMovementDTO) {
        loanInstallmentsMovementRepository.delete(loanInstallmentsMovementMapper.toEntity((loanInstallmentsMovementDTO)));
    }
    /**
     * Updates a loan installment movement.
     *
     * @param loanInstallmentsMovementDTO The updated DTO representing the loan installment movement
     * @param id                           The ID of the loan installment movement to be updated
     * @return The updated LoanInstallmentsMovementDTO object
     */
    public LoanInstallmentsMovementDTO updateLoanInstallmentsMovement(LoanInstallmentsMovementDTO loanInstallmentsMovementDTO, Long id) {
        validateLoanInstallmentsMovement(loanInstallmentsMovementDTO, id);
        return loanInstallmentsMovementMapper.toDTO(loanInstallmentsMovementRepository.save(loanInstallmentsMovementMapper.toEntity(loanInstallmentsMovementDTO)));
    }
    /**
     * Validates a loan installment movement.
     *
     * @param loanInstallmentsMovementDTO The DTO representing the loan installment movement
     * @param id                           The ID of the loan installment movement
     */
    private void validateLoanInstallmentsMovement(LoanInstallmentsMovementDTO loanInstallmentsMovementDTO, Long id) {
        if (!loanInstallmentsMovementRepository.existsById(loanInstallmentsMovementDTO.getId())) {
            throw new IllegalArgumentException("There is no LoanInstallmentsMovement with ID: " + loanInstallmentsMovementDTO.getId());
        } else if (!loanInstallmentsMovementDTO.getId().equals(id)) {
            throw new IllegalArgumentException("ID in Path doesn't match body");
        }
    }
    /**
     * Retrieves a loan installment movement by its ID.
     *
     * @param id The ID of the loan installment movement to retrieve
     * @return The LoanInstallmentsMovementDTO object with the specified ID
     * @throws EntityNotFoundException if no loan installment movement with the specified ID exists
     */
    @Transactional(readOnly = true)
    public LoanInstallmentsMovementDTO getLoanInstallmentsMovementById(Long id) {
        return loanInstallmentsMovementRepository.findById(id)
                .map(loanInstallmentsMovementMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("There is no loan installments movement with id" + id));
    }
}