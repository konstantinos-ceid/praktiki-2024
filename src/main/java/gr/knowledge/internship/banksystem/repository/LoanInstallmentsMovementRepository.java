package gr.knowledge.internship.banksystem.repository;

import gr.knowledge.internship.banksystem.entity.LoanInstallmentsMovement;
import gr.knowledge.internship.banksystem.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanInstallmentsMovementRepository extends JpaRepository<LoanInstallmentsMovement, Long> {
}
