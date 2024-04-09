package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.dto.LoanInstallmentsMovementDTO;
import gr.knowledge.internship.banksystem.service.LoanInstallmentsMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loan-installments-movements")
@CrossOrigin
public class LoanInstallmentsMovementController {

    @Autowired
    private LoanInstallmentsMovementService loanInstallmentsMovementService;

    @GetMapping
    List<LoanInstallmentsMovementDTO> getLoanInstallmentsMovements() {
        return loanInstallmentsMovementService.getLoanInstallmentsMovements();
    }

    @PostMapping
    public LoanInstallmentsMovementDTO saveLoanInstallmentsMovement(@RequestBody LoanInstallmentsMovementDTO loanInstallmentsMovementDTO) {
        return loanInstallmentsMovementService.saveLoanInstallmentsMovement(loanInstallmentsMovementDTO);
    }

    @PutMapping("/{id}")
    LoanInstallmentsMovementDTO updateLoanInstallmentsMovement(@RequestBody LoanInstallmentsMovementDTO loanInstallmentsMovementDTO, @PathVariable Long id) {
        return loanInstallmentsMovementService.updateLoanInstallmentsMovement(loanInstallmentsMovementDTO, id);
    }

    @GetMapping("/{id}")
    public LoanInstallmentsMovementDTO showLoanInstallmentsMovement(@PathVariable Long id) {
        return loanInstallmentsMovementService.getLoanInstallmentsMovementById(id);
    }
    @DeleteMapping
    public void deleteLoanInstallmentsMovement(@RequestBody LoanInstallmentsMovementDTO loanInstallmentsMovementDTO){loanInstallmentsMovementService.deleteLoanInstallmentsMovement(loanInstallmentsMovementDTO);
    }
}
