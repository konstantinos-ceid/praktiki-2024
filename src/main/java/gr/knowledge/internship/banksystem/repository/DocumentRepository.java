package gr.knowledge.internship.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.knowledge.internship.banksystem.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
