package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.dto.LoanInstallmentDTO;
import gr.knowledge.internship.banksystem.service.LoanInstallmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanInstallments")
public class LoanInstallmentController {

    @Autowired
    private LoanInstallmentService loanInstallmentService;


    @PostMapping
    public LoanInstallmentDTO createLoanInstallment(@RequestBody LoanInstallmentDTO loanInstallmentDTO) {
        return loanInstallmentService.saveLoanInstallment(loanInstallmentDTO);
    }

    @GetMapping
    public List<LoanInstallmentDTO> getAllLoanInstallments() {
        return loanInstallmentService.getAllLoanInstallments();
    }

    @GetMapping("/{id}")
    public LoanInstallmentDTO getLoanInstallmentById(@PathVariable Long id) {
        return loanInstallmentService.getLoanInstallmentById(id);
    }

    @PutMapping("/{id}")
    public LoanInstallmentDTO updateLoanInstallment(@PathVariable Long id, @RequestBody LoanInstallmentDTO loanInstallmentDTO) {
        return loanInstallmentService.updateLoanInstallment(loanInstallmentDTO, id);
    }

    @DeleteMapping
    public void deleteLoanInstallment(@RequestBody LoanInstallmentDTO loanInstallmentDTO) {
        loanInstallmentService.deleteLoanInstallment(loanInstallmentDTO);
    }
}
