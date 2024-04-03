package gr.knowledge.internship.banksystem.repository;

import gr.knowledge.internship.banksystem.entity.BankRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRegistryRepository extends JpaRepository<BankRegistry, Long> {
}
