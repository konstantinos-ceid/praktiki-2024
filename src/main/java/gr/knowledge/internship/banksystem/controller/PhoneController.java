package gr.knowledge.internship.banksystem.controller;
import gr.knowledge.internship.banksystem.dto.PhoneDTO;
import gr.knowledge.internship.banksystem.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/phones")
@CrossOrigin
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public List<PhoneDTO> getPhones(){
        return  phoneService.getPhones();
    }
    @PostMapping
    public PhoneDTO savePhone(@RequestBody  PhoneDTO phoneDTO){
        return phoneService.savePhone(phoneDTO);
    }
    @PutMapping
    public PhoneDTO updatePhone(@RequestBody PhoneDTO phoneDTO) {
        return phoneService.updatePhone(phoneDTO);
    }
    @DeleteMapping
    public void deletePhone(@RequestBody PhoneDTO phoneDTO) {phoneService.deletePhone(phoneDTO);}
    @GetMapping("/{id}")
    public PhoneDTO showPhone(@PathVariable Long id) {
        return phoneService.getPhoneById(id);
    }
}
