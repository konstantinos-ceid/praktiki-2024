package gr.knowledge.internship.banksystem.repository;

import gr.knowledge.internship.banksystem.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {
}
