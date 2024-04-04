package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.BankRegistryDTO;
import gr.knowledge.internship.banksystem.entity.BankRegistry;
import gr.knowledge.internship.banksystem.mapper.BankRegistryMapper;
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
    private BankRegistryMapper bankRegistryMapper;

    public List<BankRegistryDTO> getAllBankRegistries(){
        List<BankRegistry> companyList = bankRegistryRepository.findAll();
        return bankRegistryMapper.toDtoList(companyList);
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
        BankRegistry bankRegistry = findAndValidateIdMatch(id, bankRegistryDTO.getId());
        bankRegistryRepository.save(bankRegistry);
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
        BankRegistry bankRegistry = bankRegistryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank Registry not found with id: " + id));
        if (!bankRegistry.getId().equals(requestBodyId)) {
            throw new IllegalArgumentException("ID in path variable does not match ID in request body");
        }
        return bankRegistry;
    }
    public BankRegistryDTO saveBankRegistry(BankRegistryDTO bankRegistryDTO) {
        BankRegistry bankRegistry = bankRegistryMapper.toEntity(bankRegistryDTO);
        bankRegistryRepository.save(bankRegistry);
        return bankRegistryMapper.toDto(bankRegistry);
    }
    public void deleteBankRegistryById(Long id) {
        bankRegistryRepository.deleteById(id);
    }
}