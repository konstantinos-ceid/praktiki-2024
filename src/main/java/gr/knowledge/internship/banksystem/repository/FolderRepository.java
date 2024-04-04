package gr.knowledge.internship.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.knowledge.internship.banksystem.entity.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

}
