package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.mapper.CodedTypeMapper;
import gr.knowledge.internship.banksystem.dto.CodedTypeDto;
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
     * Updates an existing CodedType in the repository, if exists.
     * @param codedTypeDto the CodedTypeDto to update.
     * @param id the ID of the CodedType to update.
     * @return the updated CodedTypeDto.
     */
    public CodedTypeDto updateCodedType(CodedTypeDto codedTypeDto, Long id) {
        checkExistingCodedType(codedTypeDto, id);
        codedTypeRepository.save(codedTypeMapper.toEntity(codedTypeDto));
        return codedTypeDto;
    }
    /**
     * Checks if a CodedType with the given ID exists in the repository.
     * If the CodedType does not exist, it throws an IllegalArgumentException.
     * If the ID in the CodedTypeDto does not match the provided ID, it also throws an IllegalArgumentException.
     * @param codedTypeDto the CodedTypeDto containing the ID to check.
     * @param id the ID to compare with the ID in the CodedTypeDto.
     * @throws IllegalArgumentException if there is no CodedType with the given ID or if the IDs do not match.
     */
    private void checkExistingCodedType(CodedTypeDto codedTypeDto, Long id) {
        if (codedTypeRepository.findById(codedTypeDto.getId()).isEmpty()){
            throw new IllegalArgumentException("There is no CodedType with ID: "+codedTypeDto.getId());
        }
        else if (!codedTypeDto.getId().equals(id)){
            throw new IllegalArgumentException("ID in Path doesn't match body");
        }
    }
    /**
     * Deletes a CodedType from the repository if exists, else throw exception.
     * @param codedTypeDto the CodedTypeDto to delete.
     */
    public void deleteCodedType(CodedTypeDto codedTypeDto) {
        if (codedTypeRepository.findById(codedTypeDto.getId()).isEmpty()){
            throw new IllegalArgumentException("There is no CodedType with ID: "+codedTypeDto.getId()+" to delete");
        }
        codedTypeRepository.delete(codedTypeMapper.toEntity(codedTypeDto));
    }
}
