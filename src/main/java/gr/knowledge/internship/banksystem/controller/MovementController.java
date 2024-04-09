package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.dto.MovementDTO;
import gr.knowledge.internship.banksystem.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movements")
@CrossOrigin
public class MovementController {

    @Autowired
    private MovementService movementService;

    @GetMapping
    List<MovementDTO> getMovements(){ return movementService.getMovements();}
    @PostMapping
    public MovementDTO saveMovement(@RequestBody MovementDTO movementDTO){return movementService.saveMovement(movementDTO);}

    @PutMapping ("/{id}")
    MovementDTO updateMovement(@RequestBody MovementDTO movementDTO,@PathVariable Long id){return movementService.updateMovement(movementDTO,id);}
    @GetMapping("/{id}")
    public MovementDTO showMovement(@PathVariable Long id){return movementService.getMovementById(id);}

    @DeleteMapping
    public void deleteMovement(@RequestBody MovementDTO movementDTO){
        movementService.deleteMovement(movementDTO);
    }



}
