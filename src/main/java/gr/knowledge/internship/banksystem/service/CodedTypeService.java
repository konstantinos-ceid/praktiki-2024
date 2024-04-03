package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.mapper.CodedTypeMapper;
import gr.knowledge.internship.banksystem.Dto.CodedTypeDto;
import gr.knowledge.internship.banksystem.entity.CodedType;
import gr.knowledge.internship.banksystem.repository.CodedTypeRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
/**
 * Service class for managing CodedTypes.
 */
@Service
@Transactional
public class CodedTypeService {

    @Autowired
    private CodedTypeRepository codedTypeRepository;
    @Autowired
    private CodedTypeMapper codedTypeMapper;

    /**
     * Retrieves all CodedTypes from the repository and maps them to DTOs.
     * @return a list of CodedTypeDto objects.
     */
    @Transactional(readOnly = true)
    public List<CodedTypeDto> getAllCodedTypes() {
        List<CodedType> codedTypeList = codedTypeRepository.findAll();
        return codedTypeMapper.toDtoList(codedTypeList);
    }
    /**
     * Retrieves a CodedType by its ID from the repository and maps it to a DTO.
     * @param id the ID of the CodedType to retrieve.
     * @return a CodedTypeDto object.
     */
    @Transactional(readOnly = true)
    public CodedTypeDto getCodedTypeById(Long id) {
        CodedType codedType = codedTypeRepository.findById(id).orElse(null);
        return codedTypeMapper.toDto(codedType);
    }
    /**
     * Saves a new CodedType to the repository.
     * @param codedTypeDto the CodedTypeDto to save.
     * @return the saved CodedTypeDto.
     */
    public CodedTypeDto saveCodedType(CodedTypeDto codedTypeDto) {
        codedTypeRepository.save(codedTypeMapper.toEntity(codedTypeDto));
        return codedTypeDto;
    }
    /**
     * Updates an existing CodedType in the repository, if exists, else throws exception.
     * @param codedTypeDto the CodedTypeDto to update.
     * @param id the ID of the CodedType to update.
     * @return the updated CodedTypeDto.
     */
    public CodedTypeDto updateCodedType(CodedTypeDto codedTypeDto, Long id) {
        if(codedTypeRepository.findById(id).isPresent() && codedTypeDto.getId().equals(id)){
            codedTypeRepository.save(codedTypeMapper.toEntity(codedTypeDto));
        }
        else if (!codedTypeDto.getId().equals(id)){
            throw new IllegalArgumentException("Id in Path doesn't match body");
        } else if (codedTypeRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("There is no CodedType with ID: " + id);
        }
        return codedTypeDto;
    }
    /**
     * Deletes a CodedType from the repository if exists, else throw exception.
     * @param codedTypeDto the CodedTypeDto to delete.
     * @return a string indicating the success of the operation.
     */
    public String deleteCodedType(CodedTypeDto codedTypeDto) {
        if (codedTypeRepository.findById(codedTypeDto.getId()).isEmpty()){
            throw new IllegalArgumentException("There is no CodedType with ID: "+codedTypeDto.getId()+" to delete");
        }
        else {
            codedTypeRepository.delete(codedTypeMapper.toEntity(codedTypeDto));
            return "Success";
        }
    }
}
