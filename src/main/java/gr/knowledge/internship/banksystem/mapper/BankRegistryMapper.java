package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.BankRegistryDTO;
import gr.knowledge.internship.banksystem.dto.CodedTypeDto;
import gr.knowledge.internship.banksystem.entity.BankRegistry;
import gr.knowledge.internship.banksystem.entity.CodedType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BankRegistryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public BankRegistryDTO toDto(BankRegistry bankRegistry) {
        return modelMapper.map(bankRegistry, BankRegistryDTO.class);
    }

    public BankRegistry toEntity(BankRegistryDTO bankRegistryDTO) {
        return modelMapper.map(bankRegistryDTO, BankRegistry.class);
    }

    public List<BankRegistry> toEntityList(List<BankRegistryDTO> bankRegistryDTOList) {
        return bankRegistryDTOList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<BankRegistryDTO> toDtoList(List<BankRegistry> bankRegistryList) {
        return bankRegistryList.stream().map(this::toDto).collect(Collectors.toList());
    }
}