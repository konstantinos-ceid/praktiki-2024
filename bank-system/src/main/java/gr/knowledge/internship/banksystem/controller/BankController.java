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
    public List<BankDTO> getBonus(){
        return  bankService.getBanks();
    }

    @PostMapping
    public  BankDTO saveBonus(@RequestBody  BankDTO bankDTO){
        return bankService.saveBank(bankDTO);
    }
    @PutMapping
    public BankDTO updateBank(@RequestBody BankDTO bankDTO) {
        return bankService.updateBank(bankDTO);
    }

    @DeleteMapping
    public boolean deleteBank(@RequestBody BankDTO bankDTO) {

        return bankService.deleteBank(bankDTO);
    }
    @GetMapping("/bank/{id}")
    public BankDTO showBank(@PathVariable Long id) {
        return bankService.getBankById(id);

    }
}
