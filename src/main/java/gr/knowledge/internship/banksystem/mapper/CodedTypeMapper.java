package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.CodedTypeDTO;
import gr.knowledge.internship.banksystem.entity.CodedType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodedTypeMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CodedTypeDTO toDto(CodedType codedType) {
        return modelMapper.map(codedType, CodedTypeDTO.class);
    }

    public CodedType toEntity(CodedTypeDTO codedTypeDto) {
        return modelMapper.map(codedTypeDto, CodedType.class);
    }

    public List<CodedType> toEntityList(List<CodedTypeDTO> codedTypeDtoList) {
        return codedTypeDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<CodedTypeDTO> toDtoList(List<CodedType> codedTypeList) {
        return codedTypeList.stream().map(this::toDto).collect(Collectors.toList());
    }
}