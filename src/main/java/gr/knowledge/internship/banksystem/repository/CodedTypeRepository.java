package gr.knowledge.internship.banksystem.repository;
import gr.knowledge.internship.banksystem.entity.CodedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodedTypeRepository extends JpaRepository<CodedType, Long> {

}
