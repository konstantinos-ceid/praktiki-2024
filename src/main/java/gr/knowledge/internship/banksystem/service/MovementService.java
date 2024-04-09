package gr.knowledge.internship.banksystem.service;


import gr.knowledge.internship.banksystem.dto.MovementDTO;
import gr.knowledge.internship.banksystem.entity.Movement;
import gr.knowledge.internship.banksystem.mapper.MovementMapper;
import gr.knowledge.internship.banksystem.repository.MovementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Service class for managing movements.
 */
@Service
@Transactional
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private MovementMapper movementMapper;

    /**
     * Retrieves all movements.
     *
     * @return List of MovementDTOs representing all movements.
     */
    @Transactional(readOnly=true)
    public List<MovementDTO> getMovements(){
        return movementMapper.toDTOList(movementRepository.findAll());
    }

    /**
     * Saves a new movement.
     *
     * @param movementDTO The MovementDTO to be saved.
     * @return The saved MovementDTO.
     */
    public MovementDTO saveMovement(MovementDTO movementDTO){
        return movementMapper.toDTO(movementRepository.save(movementMapper.toEntity(movementDTO)));
    }

    /**
     * Deletes a movement.
     *
     * @param movementDTO The MovementDTO to be deleted.
     */
    public void deleteMovement(MovementDTO movementDTO){
        movementRepository.delete(movementMapper.toEntity((movementDTO)));
    }
    /**
     * Updates a movement with the given ID using the provided MovementDTO.
     * Validates the MovementDTO against the provided ID before updating.
     *
     * @param movementDTO The MovementDTO containing the updated movement details.
     * @param id          The ID of the movement to be updated.
     * @return The updated MovementDTO.
     * @throws IllegalArgumentException if the movement with the given ID does not exist or if the ID in the path does not match the ID in the DTO.
     */
    public MovementDTO updateMovement(MovementDTO movementDTO, Long id) {
        validateMovement(movementDTO, id);
        return movementMapper.toDTO(movementRepository.save(movementMapper.toEntity(movementDTO)));

    }
    /**
     * Validates the provided MovementDTO against the given ID.
     *
     * @param movementDTO The MovementDTO to be validated.
     * @param id          The ID against which the MovementDTO is validated.
     * @throws IllegalArgumentException if the movement with the given ID does not exist or if the ID in the path does not match the ID in the DTO.
     */

    private void validateMovement(MovementDTO movementDTO,Long id){
        if(movementRepository.existsById(movementDTO.getId())){
            throw new  IllegalArgumentException("There is no Movement with ID: "+movementDTO.getId());
        }
        else if(!movementDTO.getId().equals(id)){
            throw new IllegalArgumentException("ID in Path doesn't match body");
        }

    }
    /**
     * Retrieves a movement by its ID.
     *
     * @param id The ID of the movement to retrieve.
     * @return The MovementDTO representing the requested movement.
     * @throws EntityNotFoundException if no movement with the given ID exists.
     */
    @Transactional(readOnly = true)
    public MovementDTO getMovementById(Long id){
        return movementRepository.findById(id)
                .map(movementMapper:: toDTO)
                .orElseThrow(()-> new EntityNotFoundException("There is no movement with id"+ id));
    }

}
