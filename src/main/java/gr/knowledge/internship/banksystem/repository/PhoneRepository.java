package gr.knowledge.internship.banksystem.repository;

import gr.knowledge.internship.banksystem.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
