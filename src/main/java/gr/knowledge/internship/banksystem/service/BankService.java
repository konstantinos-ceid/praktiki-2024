package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.BankDTO;
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
     * Updates an existing bank.
     *
     * @param bankDTO the bank DTO to be updated
     * @return the updated bank DTO
     */
    public BankDTO updateBank(BankDTO bankDTO){
        return bankMapper.toDTO(bankRepository.save(bankMapper.toEntity(bankDTO)));
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

