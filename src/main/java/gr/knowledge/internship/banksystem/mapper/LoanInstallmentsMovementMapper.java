package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.LoanInstallmentsMovementDTO;
import gr.knowledge.internship.banksystem.entity.LoanInstallmentsMovement;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanInstallmentsMovementMapper {

    @Autowired
    private ModelMapper modelMapper;

    public List<LoanInstallmentsMovement> toEntityList(List<LoanInstallmentsMovementDTO> loanMovementDTOs){
        return modelMapper.map(loanMovementDTOs,new TypeToken<List<LoanInstallmentsMovement>>(){}.getType());
    }
    public List<LoanInstallmentsMovementDTO> toDTOList(List<LoanInstallmentsMovement> loanMovements){
        return modelMapper.map(loanMovements,new TypeToken<List<LoanInstallmentsMovementDTO>>(){}.getType());
    }
    public LoanInstallmentsMovement toEntity(LoanInstallmentsMovementDTO loanMovementDTO){
        return modelMapper.map(loanMovementDTO,LoanInstallmentsMovement.class);
    }
    public LoanInstallmentsMovementDTO toDTO(LoanInstallmentsMovement loanMovement){
        return  modelMapper.map(loanMovement,LoanInstallmentsMovementDTO.class);
    }
}
