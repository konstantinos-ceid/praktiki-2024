package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.BankRegistryDTO;
import gr.knowledge.internship.banksystem.entity.BankRegistry;
import gr.knowledge.internship.banksystem.mapper.BankRegistryMapper;
import gr.knowledge.internship.banksystem.repository.BankRegistryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Log4j2
public class BankRegistryService {

    @Autowired
    private BankRegistryRepository bankRegistryRepository;
    @Autowired
    private BankRegistryMapper bankRegistryMapper;

    /**
     * Retrieves all bank registries.
     *
     * @return List of BankRegistryDTO containing all bank registries.
     */
    public List<BankRegistryDTO> getAllBankRegistries(){
        List<BankRegistry> companyList = bankRegistryRepository.findAll();
        return bankRegistryMapper.convertListToDto(companyList, BankRegistryDTO.class);
    }


    /**
     * Updates a bank registry.
     *
     * @param id              The ID of the bank registry to be updated.
     * @param bankRegistryDTO The updated bank registry data.
     * @return BankRegistryDTO representing the updated bank registry.
     * @throws RuntimeException if the bank registry with the given ID is not found.
     */
    public BankRegistryDTO updateBankRegistry(Long id, BankRegistryDTO bankRegistryDTO) {
        BankRegistry existingBankRegistry = bankRegistryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank Registry not found with id: " + id));
        //check if the ID in the path variable matches the ID in the request body
        if (!existingBankRegistry.getId().equals(bankRegistryDTO.getId())) {
            throw new IllegalArgumentException("ID in path variable does not match ID in request body");
        }
        existingBankRegistry.setName(bankRegistryDTO.getName());
        bankRegistryRepository.save(existingBankRegistry);
        return bankRegistryDTO;
    }

    /**
     * Saves a new bank registry.
     *
     * @param bankRegistryDTO The bank registry data to be saved.
     * @return BankRegistryDTO representing the saved bank registry.
     */
    public BankRegistryDTO saveBankRegistry(BankRegistryDTO bankRegistryDTO) {
        BankRegistry bankRegistry = bankRegistryMapper.convertToEntity(bankRegistryDTO, BankRegistry.class);
        bankRegistryRepository.save(bankRegistry);
        return bankRegistryMapper.convertToDto(bankRegistry, BankRegistryDTO.class);
    }

    /**
     * Deletes all bank registries.
     */
    public void deleteAllBankRegistries() {
        bankRegistryRepository.deleteAll();
    }
}
