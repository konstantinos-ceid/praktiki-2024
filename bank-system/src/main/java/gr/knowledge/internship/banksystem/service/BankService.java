package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.BankDTO;
import gr.knowledge.internship.banksystem.entity.Bank;
import gr.knowledge.internship.banksystem.repository.BankRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankService {

    @Autowired
    private BankRepository bankRepository;

 @Autowired
   private ModelMapper modelMapper;


    public List<BankDTO> getBanks(){
        List<Bank> allBanks=bankRepository.findAll();

       List<BankDTO> allBanksDTO= modelMapper.map(allBanks,new TypeToken<List<BankDTO>>(){}.getType());

        return allBanksDTO;
    }

    public BankDTO saveBank(BankDTO bankDTO){
        Bank savedBank =bankRepository.save(modelMapper.map(bankDTO, Bank.class));
        return bankDTO;
    }

    public BankDTO updateBank(BankDTO bankDTO){
        Bank updatedBank =bankRepository.save(modelMapper.map(bankDTO,Bank.class));
        return bankDTO;
    }

    public boolean deleteBank(BankDTO bankDTO) {
        bankRepository.delete(modelMapper.map(bankDTO, Bank.class));
        return true;
    }

    public BankDTO getBankById(Long id){
        Optional<Bank> bankOptional = bankRepository.findById(id);

        BankDTO bankDTO = modelMapper.map(bankOptional.get(), BankDTO.class);
        return bankDTO;
    }
    }
