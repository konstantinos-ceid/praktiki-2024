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

@Service
@Transactional
public class FolderService {
	@Autowired
	private FolderRepository folderRepository;
	@Autowired
	private FolderMapper folderMapper;

	@Transactional(readOnly = true)
	public FolderDTO getFolderById(Long id) {
		Folder folder = folderRepository.getReferenceById(id);
		return folderMapper.toDTO(folder);
	}

	@Transactional(readOnly = true)
	public List<FolderDTO> getAllFolders() {
		List<Folder> allFolders = folderRepository.findAll();
		return folderMapper.toDTOList(allFolders);
	}

	public FolderDTO saveFolder(FolderDTO folderDTO) {
		Folder folderToSave = folderMapper.toEntity(folderDTO);
		folderRepository.save(folderToSave);
		return folderMapper.toDTO(folderToSave);
	}

	public FolderDTO updateFolder(FolderDTO folderDTO) {
		if(this.existsInDatabase(folderDTO)) {
			Folder folderToSave = folderMapper.toEntity(folderDTO);
			folderRepository.save(folderToSave);
		}
		return folderDTO;
	}


	public void deleteFolder(FolderDTO folderDTO) {
		Folder folderToDelete = folderMapper.toEntity(folderDTO);
		folderRepository.delete(folderToDelete);
	}

	private boolean existsInDatabase(FolderDTO folderDTO) {
		try {
//			TODO global EntityNotFoundException handler
			Folder folderInDatabase = folderRepository.getReferenceById(folderDTO.getId());
			return folderInDatabase != null;
		} catch (NullPointerException npe) {
			throw new EntityNotFoundException("Null folder ID given.");
		}
	}
}
