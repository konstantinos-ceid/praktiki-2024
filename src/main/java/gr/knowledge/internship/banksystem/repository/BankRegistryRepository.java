package gr.knowledge.internship.banksystem.repository;

import gr.knowledge.internship.banksystem.entity.BankRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRegistryRepository extends JpaRepository<BankRegistry, Integer> {
}
