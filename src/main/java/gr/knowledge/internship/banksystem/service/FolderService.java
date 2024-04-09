package gr.knowledge.internship.banksystem.service;

import java.util.List;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.knowledge.internship.banksystem.dto.FolderDTO;
import gr.knowledge.internship.banksystem.entity.Folder;
import gr.knowledge.internship.banksystem.mapper.FolderMapper;
import gr.knowledge.internship.banksystem.repository.FolderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;

/**
 * This class provides services for managing folders in the bank system.
 */
@Service
@Transactional
@Log4j2
public class FolderService {

	@Autowired
	private FolderRepository folderRepository;
	@Autowired
	private FolderMapper folderMapper;

	/**
	 * Retrieves a folder by its ID.
	 *
	 * @param id The ID of the folder to retrieve.
	 * @return The DTO representation of the folder.
	 * @throws EntityNotFoundException If the folder with the given ID is not found.
	 */
	@Transactional(readOnly = true)
	public FolderDTO getFolderById(Long id) {
		ThreadContext.put("folderId", id.toString());
		Folder folder = folderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		log.debug("Request for folder with id");
		ThreadContext.clearAll();
		return folderMapper.toDTO(folder);
	}

	/**
	 * Retrieves all folders.
	 *
	 * @return A list of DTO representations of all folders.
	 */
	@Transactional(readOnly = true)
	public List<FolderDTO> getAllFolders() {
		List<Folder> allFolders = folderRepository.findAll();
		ThreadContext.put("numberOfFolders", String.valueOf(allFolders.size()));
		log.debug("Requested all folders");
		ThreadContext.clearAll();
		return folderMapper.toDTOList(allFolders);
	}

	/**
	 * Saves a new folder.
	 *
	 * @param folderDTO The DTO representation of the folder to be saved.
	 * @return The DTO representation of the saved folder.
	 */
	public FolderDTO saveFolder(FolderDTO folderDTO) {
		ThreadContext.put("folderEntity", folderDTO.toString());
		Folder folder = folderMapper.toEntity(folderDTO);
		log.debug("Saving new folder");
		folderRepository.save(folder);
		ThreadContext.clearAll();
		return folderMapper.toDTO(folder);
	}

	/**
	 * Updates an existing folder.
	 *
	 * @param folderDTO The DTO representation of the folder to be updated.
	 * @return The DTO representation of the updated folder.
	 */
	public FolderDTO updateFolder(FolderDTO folderDTO) {
		ThreadContext.put("folder", folderDTO.toString());
		Folder folder = this.existsInDatabase(folderDTO);
		folder = folderMapper.toEntity(folderDTO);
		folderRepository.save(folder);
		log.debug("Updating folder");
		return folderDTO;
	}

	/**
	 * Deletes a folder.
	 *
	 * @param folderDTO The DTO representation of the folder to be deleted.
	 */
	public void deleteFolder(FolderDTO folderDTO) {
		ThreadContext.put("folder", folderDTO.toString());
		Folder folder = folderMapper.toEntity(folderDTO);
		log.debug("Deleting folder");
		ThreadContext.clearAll();
		folderRepository.delete(folder);
	}

	private Folder existsInDatabase(FolderDTO folderDTO) {
		Folder folderInDatabase = folderRepository.findById(folderDTO.getId())
				.orElseThrow(EntityNotFoundException::new);
		ThreadContext.put("existingFolder", folderDTO.toString());
		log.debug("Folder exists in database");
		return folderInDatabase;
	}
}