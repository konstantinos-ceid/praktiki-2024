package gr.knowledge.internship.banksystem.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.knowledge.internship.banksystem.dto.FolderDTO;
import gr.knowledge.internship.banksystem.entity.Folder;
import gr.knowledge.internship.banksystem.repository.FolderRepository;

@Service
@Transactional
public class FolderService {
	@Autowired
	private FolderRepository folderRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	public FolderDTO getFolderById(Long id) {
		Folder folder = folderRepository.getReferenceById(id);
		return modelMapper.map(folder, FolderDTO.class);
	}

	@Transactional(readOnly = true)
	public List<FolderDTO> getAllFolders() {
		List<Folder> allFolders = folderRepository.findAll();
		return modelMapper.map(allFolders, new TypeToken<List<FolderDTO>>() {
		}.getType());
	}

	public FolderDTO saveFolder(FolderDTO folderDTO) {
		Folder folderToSave = modelMapper.map(folderDTO, Folder.class);
		folderRepository.save(folderToSave);
		return modelMapper.map(folderToSave, FolderDTO.class);
	}

	public FolderDTO updateFolder(FolderDTO folderDTO) {
		Folder folderToUpdate = modelMapper.map(folderDTO, Folder.class);
		folderRepository.save(folderToUpdate);
		return modelMapper.map(folderToUpdate, FolderDTO.class);
	}

	public void deleteFolder(FolderDTO folderDTO) {
		Folder folderToDelete = modelMapper.map(folderDTO, Folder.class);
		folderRepository.delete(folderToDelete);
	}
}
