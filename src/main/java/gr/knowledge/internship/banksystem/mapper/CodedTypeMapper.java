package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.CodedTypeDto;
import gr.knowledge.internship.banksystem.entity.CodedType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodedTypeMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CodedTypeDto toDto(CodedType codedType) {
        return modelMapper.map(codedType, CodedTypeDto.class);
    }

    public CodedType toEntity(CodedTypeDto codedTypeDto) {
        return modelMapper.map(codedTypeDto, CodedType.class);
    }

    public List<CodedType> toEntityList(List<CodedTypeDto> codedTypeDtoList) {
        return codedTypeDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<CodedTypeDto> toDtoList(List<CodedType> codedTypeList) {
        return codedTypeList.stream().map(this::toDto).collect(Collectors.toList());
    }
}