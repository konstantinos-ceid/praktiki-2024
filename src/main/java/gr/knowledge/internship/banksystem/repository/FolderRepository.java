package gr.knowledge.internship.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.knowledge.internship.banksystem.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {

}
