 package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.dto.LoanDTO;
import gr.knowledge.internship.banksystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private  LoanService loanService;

    @PostMapping
    public LoanDTO createLoan(@RequestBody LoanDTO loanDTO) {
        return loanService.saveLoan(loanDTO);
    }

    @GetMapping
    public List<LoanDTO> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public LoanDTO getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @PutMapping("/{id}")
    public LoanDTO updateLoan(@PathVariable Long id, @RequestBody LoanDTO loanDTO) { return loanService.updateLoan(loanDTO, id); }

    @DeleteMapping
    public void deleteLoan(@RequestBody LoanDTO loanDTO) {
        loanService.deleteLoan(loanDTO);
    }
}

