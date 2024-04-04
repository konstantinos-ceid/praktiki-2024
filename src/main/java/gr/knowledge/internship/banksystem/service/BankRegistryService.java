package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.BankRegistryDTO;
import gr.knowledge.internship.banksystem.entity.BankRegistry;
import gr.knowledge.internship.banksystem.repository.BankRegistryRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    private ModelMapper modelMapper;

    public List<BankRegistryDTO> getAllBankRegistries(){
        List<BankRegistry> companyList = bankRegistryRepository.findAll();
        return modelMapper.map(companyList, new TypeToken<List<BankRegistryDTO>>(){}.getType());
    }

    /**
     * Updates the details of a bank registry.
     *
     * @param id              The ID of the bank registry to be updated.
     * @param bankRegistryDTO The updated bank registry data.
     * @return The updated bank registry DTO.
     * @throws IllegalArgumentException If the ID in the path variable does not match the ID in the request body.
     * @throws RuntimeException         If the bank registry with the given ID is not found.
     */
    public BankRegistryDTO updateBankRegistry(Long id, BankRegistryDTO bankRegistryDTO) {
        BankRegistry existingBankRegistry = findAndValidateIdMatch(id, bankRegistryDTO.getId());
        existingBankRegistry.setName(bankRegistryDTO.getName());
        bankRegistryRepository.save(existingBankRegistry);
        return bankRegistryDTO;
    }

    /**
     * Finds a bank registry by ID and validates if the ID in the path variable matches the ID in the request body.
     *
     * @param id            The ID of the bank registry to find.
     * @param requestBodyId The ID present in the request body.
     * @return The bank registry if found and the IDs match.
     * @throws IllegalArgumentException If the ID in the path variable does not match the ID in the request body.
     * @throws RuntimeException         If the bank registry with the given ID is not found.
     */
    private BankRegistry findAndValidateIdMatch(Long id, Long requestBodyId) {
        BankRegistry existingBankRegistry = bankRegistryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank Registry not found with id: " + id));
        if (!existingBankRegistry.getId().equals(requestBodyId)) {
            throw new IllegalArgumentException("ID in path variable does not match ID in request body");
        }
        return existingBankRegistry;
    }
    public BankRegistryDTO saveBankRegistry(BankRegistryDTO bankRegistryDTO) {
        bankRegistryRepository.save(modelMapper.map(bankRegistryDTO, BankRegistry.class));
        return bankRegistryDTO;
    }
    public void deleteAllBankRegistries() {
        bankRegistryRepository.deleteAll();
    }
}