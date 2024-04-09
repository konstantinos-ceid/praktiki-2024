package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.dto.BankDTO;
import gr.knowledge.internship.banksystem.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "api/banks")
@CrossOrigin
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping
    public List<BankDTO> getBank(){
        return  bankService.getBanks();
    }

    @PostMapping
    public  BankDTO saveBank(@RequestBody  BankDTO bankDTO){
        return bankService.saveBank(bankDTO);
    }
    @PutMapping("/{id}")
    public BankDTO updateBank(@RequestBody BankDTO bankDTO,@PathVariable Long id) {
        return bankService.updateBank(bankDTO,id);
    }

    @DeleteMapping
    public void deleteBank(@RequestBody BankDTO bankDTO) {

         bankService.deleteBank(bankDTO);
    }
    @GetMapping("/{id}")
    public BankDTO showBank(@PathVariable Long id) {
        return bankService.getBankById(id);

    }
}
