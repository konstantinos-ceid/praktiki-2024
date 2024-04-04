package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.BankDTO;
import gr.knowledge.internship.banksystem.entity.Bank;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankMapper {
    @Autowired
    private ModelMapper modelMapper;

    public List<Bank> toEntity(List<BankDTO> bankDTOs){
        return  modelMapper.map(bankDTOs,new TypeToken<List<Bank>>(){}.getType());
    }

    public List<BankDTO> toDTO(List<Bank> banks){
        return  modelMapper.map(banks,new TypeToken<List<BankDTO>>(){}.getType());
    }

    public Bank toEntity(BankDTO bankDTO){
        return modelMapper.map(bankDTO,Bank.class);
    }

    public BankDTO toDTO(Bank bank){
        return modelMapper.map(bank,BankDTO.class);
    }
}
