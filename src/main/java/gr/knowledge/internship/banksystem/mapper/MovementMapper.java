package gr.knowledge.internship.banksystem.mapper;
import gr.knowledge.internship.banksystem.dto.MovementDTO;
import gr.knowledge.internship.banksystem.entity.Movement;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovementMapper {
    @Autowired
    private ModelMapper modelMapper;

    public List<Movement> toEntityList(List<MovementDTO> movementDTOs){
        return  modelMapper.map(movementDTOs,new TypeToken<List<Movement>>(){}.getType());
    }
    public List<MovementDTO> toDTOList(List<Movement> movements){
        return  modelMapper.map(movements,new TypeToken<List<MovementDTO>>(){}.getType());
    }
    public Movement toEntity(MovementDTO movementDTO){
        return modelMapper.map(movementDTO,Movement.class);
    }
    public MovementDTO toDTO(Movement movement){
        return modelMapper.map(movement,MovementDTO.class);
    }
}
