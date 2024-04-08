package gr.knowledge.internship.banksystem.repository;

import gr.knowledge.internship.banksystem.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}
