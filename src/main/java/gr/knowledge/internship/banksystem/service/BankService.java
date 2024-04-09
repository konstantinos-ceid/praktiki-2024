package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.BankDTO;
import gr.knowledge.internship.banksystem.dto.PhoneDTO;
import gr.knowledge.internship.banksystem.mapper.BankMapper;
import gr.knowledge.internship.banksystem.repository.BankRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing banks.
 */

@Service
@Transactional
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BankMapper bankMapper;

    /**
     * Retrieves all banks.
     *
     * @return a list of all banks
     */
    @Transactional(readOnly=true)
    public List<BankDTO> getBanks(){
       return bankMapper.toDTOList(bankRepository.findAll());
    }
    /**
     * Saves a new bank.
     *
     * @param bankDTO the bank DTO to be saved
     * @return the saved bank DTO
     */
    public BankDTO saveBank(BankDTO bankDTO){
        return bankMapper.toDTO(bankRepository.save(bankMapper.toEntity(bankDTO)));
    }
    /**
     * Updates the bank details with the given ID using the provided bank DTO.
     * Validates the bank DTO against the provided ID before updating.
     *
     * @param bankDTO The bank DTO containing the updated bank details.
     * @param id      The ID of the bank to be updated.
     * @return The updated bank DTO.
     * @throws IllegalArgumentException if the bank with the given ID does not exist or if the ID in the path does not match the ID in the DTO.
     */
    public BankDTO updateBank(BankDTO bankDTO,Long id){
        validateBank(bankDTO,id);
        return bankMapper.toDTO(bankRepository.save(bankMapper.toEntity(bankDTO)));
    }
    /**
     * Validates the given bank DTO against the provided ID.
     *
     * @param bankDTO The bank DTO to be validated.
     * @param id      The ID against which the bank DTO is validated.
     * @throws IllegalArgumentException if the bank with the given ID does not exist or if the ID in the path does not match the ID in the DTO.
     */
    private void validateBank(BankDTO bankDTO, Long id){
        if(bankRepository.existsById(bankDTO.getId())){
            throw new IllegalArgumentException("There is no bank with id"+ bankDTO.getId());
        }
        else if(!bankDTO.getId().equals(id)){
            throw new IllegalArgumentException("ID in Path doesn't match body");
        }
    }
    /**
     * Deletes a bank.
     *
     * @param bankDTO the bank DTO to be deleted
     * @return {@code true} if the bank is deleted successfully, {@code false} otherwise
     */
    public void deleteBank(BankDTO bankDTO) {
        bankRepository.delete(bankMapper.toEntity(bankDTO));

    } /**
     * Retrieves a bank by its ID.
     *
     * @param id the ID of the bank to retrieve
     * @return the bank DTO if found
     * @throws EntityNotFoundException if no bank with the given ID is found
     */
    @Transactional(readOnly = true)
    public BankDTO getBankById(Long id) {
        return bankRepository.findById(id)
                .map(bankMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("There is no Bank with ID: " + id));
    }
    }

