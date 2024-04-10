package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.LoanInstallmentDTO;
import gr.knowledge.internship.banksystem.entity.LoanInstallment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanInstallmentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public LoanInstallmentDTO toDto(LoanInstallment loanInstallment) {
        return modelMapper.map(loanInstallment, LoanInstallmentDTO.class);
    }

    public LoanInstallment toEntity(LoanInstallmentDTO loanInstallmentDto) {
        return modelMapper.map(loanInstallmentDto, LoanInstallment.class);
    }

    public List<LoanInstallment> toEntityList(List<LoanInstallmentDTO> loanInstallmentDtoList) {
        return loanInstallmentDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<LoanInstallmentDTO> toDtoList(List<LoanInstallment> loanInstallmentList) {
        return loanInstallmentList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
