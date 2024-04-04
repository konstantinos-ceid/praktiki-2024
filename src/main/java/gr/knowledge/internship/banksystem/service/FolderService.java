package gr.knowledge.internship.banksystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.knowledge.internship.banksystem.dto.FolderDTO;
import gr.knowledge.internship.banksystem.entity.Folder;
import gr.knowledge.internship.banksystem.mapper.FolderMapper;
import gr.knowledge.internship.banksystem.repository.FolderRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 * This class provides services for managing folders in the bank system.
 */
@Service
@Transactional
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
		Folder folder = folderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
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
		return folderMapper.toDTOList(allFolders);
	}

	/**
	 * Saves a new folder.
	 *
	 * @param folderDTO The DTO representation of the folder to be saved.
	 * @return The DTO representation of the saved folder.
	 */
	public FolderDTO saveFolder(FolderDTO folderDTO) {
		Folder folder = folderMapper.toEntity(folderDTO);
		folderRepository.save(folder);
		return folderMapper.toDTO(folder);
	}

	/**
	 * Updates an existing folder.
	 *
	 * @param folderDTO The DTO representation of the folder to be updated.
	 * @return The DTO representation of the updated folder.
	 */
	public FolderDTO updateFolder(FolderDTO folderDTO) {
		Folder folder = this.existsInDatabase(folderDTO);
		folder = folderMapper.toEntity(folderDTO);
		folderRepository.save(folder);
		return folderDTO;
	}

	/**
	 * Deletes a folder.
	 *
	 * @param folderDTO The DTO representation of the folder to be deleted.
	 */
	public void deleteFolder(FolderDTO folderDTO) {
		Folder folder = folderMapper.toEntity(folderDTO);
		folderRepository.delete(folder);
	}

	private Folder existsInDatabase(FolderDTO folderDTO) {
		Folder folderInDatabase = folderRepository.findById(folderDTO.getId())
				.orElseThrow(EntityNotFoundException::new);
		return folderInDatabase;
	}
}