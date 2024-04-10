package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.LoanDTO;
import gr.knowledge.internship.banksystem.entity.Loan;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public LoanDTO toDto(Loan loan) {
        return modelMapper.map(loan, LoanDTO.class);
    }

    public Loan toEntity(LoanDTO loanDto) {
        return modelMapper.map(loanDto, Loan.class);
    }

    public List<Loan> toEntityList(List<LoanDTO> loanDtoList) {
        return loanDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<LoanDTO> toDtoList(List<Loan> loanList) {
        return loanList.stream().map(this::toDto).collect(Collectors.toList());
    }
    
}
