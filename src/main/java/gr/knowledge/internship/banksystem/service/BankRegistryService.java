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

    public BankRegistryDTO updateBankRegistry(BankRegistryDTO companyDTO){
        bankRegistryRepository.save(modelMapper.map(companyDTO,BankRegistry.class));
        return companyDTO;
    }
    public BankRegistryDTO saveBankRegistry(BankRegistryDTO bankRegistryDTO) {
        bankRegistryRepository.save(modelMapper.map(bankRegistryDTO, BankRegistry.class));
        return bankRegistryDTO;
    }
    public void deleteAllBankRegistries() {
        bankRegistryRepository.deleteAll();
    }
}
