package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.PhoneDTO;
import gr.knowledge.internship.banksystem.entity.Phone;
import gr.knowledge.internship.banksystem.mapper.PhoneMapper;
import gr.knowledge.internship.banksystem.repository.PhoneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service class for managing phones.
 */
@Service
@Transactional
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;



    @Autowired
    private PhoneMapper phoneMapper;

    /**
     * Retrieves all phones.
     *
     * @return a list of all phones
     */
    @Transactional(readOnly=true)
    public List<PhoneDTO> getPhones(){
        return phoneMapper.toDTOList(phoneRepository.findAll());
    }

    /**
     * Saves a new phone.
     *
     * @param phoneDTO the phone DTO to be saved
     * @return the saved phone DTO
     */
    public PhoneDTO savePhone(PhoneDTO phoneDTO){
        return phoneMapper.toDTO(phoneRepository.save(phoneMapper.toEntity(phoneDTO)));
    }
    /**
     * Updates the phone details with the given ID using the provided phone DTO.
     * Validates the phone DTO against the provided ID before updating.
     *
     * @param phoneDTO The phone DTO containing the updated phone details.
     * @param id       The ID of the phone to be updated.
     * @return The updated phone DTO.
     * @throws IllegalArgumentException if the phone with the given ID does not exist or if the ID in the path does not match the ID in the DTO.
     */
    public PhoneDTO updatePhone(PhoneDTO phoneDTO,Long id ){
        validatePhone(phoneDTO,id);
        return phoneMapper.toDTO(phoneRepository.save(phoneMapper.toEntity(phoneDTO)));
    }

    /**
     * Validates the given phone DTO against the provided ID.
     *
     * @param phoneDTO The phone DTO to be validated.
     * @param id       The ID against which the phone DTO is validated.
     * @throws IllegalArgumentException if the phone with the given ID does not exist or if the ID in the path does not match the ID in the DTO.
     */
    private void validatePhone(PhoneDTO phoneDTO,Long id){
        if(phoneRepository.existsById(phoneDTO.getId())){
            throw new IllegalArgumentException("There is no Phone with id"+ phoneDTO.getId());
        }
        else if(!phoneDTO.getId().equals(id)){
            throw new IllegalArgumentException("ID in Path doesn't match body");
        }
    }
    /**
     * Deletes a phone.
     *
     * @param phoneDTO the phone DTO to be deleted
     * @return {@code true} if the phone is deleted successfully, {@code false} otherwise
     */
    public void deletePhone(PhoneDTO phoneDTO) {
        phoneRepository.delete(phoneMapper.toEntity(phoneDTO));

    }
    /**
     * Retrieves a phone by its ID.
     *
     * @param id the ID of the phone to retrieve
     * @return the phone DTO if found
     * @throws EntityNotFoundException if no phone with the given ID is found
     */
    @Transactional(readOnly=true)
    public PhoneDTO getPhoneById(Long id){
        return phoneRepository.findById(id)
                .map(phoneMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("There is no Bank with ID: " + id));
    }
}
