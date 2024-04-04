package gr.knowledge.internship.banksystem.service;
import gr.knowledge.internship.banksystem.dto.PhoneDTO;
import gr.knowledge.internship.banksystem.mapper.PhoneMapper;
import gr.knowledge.internship.banksystem.repository.PhoneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
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
     * Updates an existing phone.
     *
     * @param phoneDTO the phone DTO to be updated
     * @return the updated phone DTO
     */
    public PhoneDTO updatePhone(PhoneDTO phoneDTO){
        return phoneMapper.toDTO(phoneRepository.save(phoneMapper.toEntity(phoneDTO)));
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
