package gr.knowledge.internship.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.knowledge.internship.banksystem.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
