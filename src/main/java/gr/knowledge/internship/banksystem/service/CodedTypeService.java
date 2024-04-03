package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.Dto.CodedTypeDto;
import gr.knowledge.internship.banksystem.entity.CodedType;
import gr.knowledge.internship.banksystem.repository.CodedTypeRepository;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.List;
@Service
@Transactional
public class CodedTypeService {

    @Autowired
    private CodedTypeRepository codedTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<CodedTypeDto> getAllCodedTypes() {
        List<CodedType> codedTypeList = codedTypeRepository.findAll();
        return  modelMapper.map(codedTypeList, new TypeToken<List<CodedTypeDto>>() {
        }.getType());
    }

    @Transactional(readOnly = true)
    public CodedTypeDto getCodedTypeById(Long id) {
        CodedType codedType = codedTypeRepository.findById(id).orElse(null);
        return modelMapper.map(codedType, CodedTypeDto.class);
    }
    //used for both create and update
    public CodedTypeDto saveCodedType(CodedTypeDto codedTypeDto) {
        codedTypeRepository.save(modelMapper.map(codedTypeDto, CodedType.class));
        return codedTypeDto;
    }

    public String deleteCodedType(CodedTypeDto codedTypeDto) {
        codedTypeRepository.delete(modelMapper.map(codedTypeDto, CodedType.class));
        return "Success";
    }
}
