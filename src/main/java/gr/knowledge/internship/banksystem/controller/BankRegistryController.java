package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.dto.BankRegistryDTO;
import gr.knowledge.internship.banksystem.service.BankRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-registry")
public class BankRegistryController {

    @Autowired
    private BankRegistryService bankRegistryService;
    @GetMapping()
    public List<BankRegistryDTO> getBankRegistries(){
        return bankRegistryService.getAllBankRegistries();
    }
    @PostMapping()
    public BankRegistryDTO saveBankRegistry(@RequestBody BankRegistryDTO bankRegistryDTO){
        return bankRegistryService.saveBankRegistry(bankRegistryDTO);
    }
    @PutMapping()
    public BankRegistryDTO updateBankRegistry(@RequestBody BankRegistryDTO bankRegistryDTO){
        return bankRegistryService.updateBankRegistry(bankRegistryDTO);
    }
    @DeleteMapping
    public void deleteAllBankRegistries() {
        bankRegistryService.deleteAllBankRegistries();
    }
}
