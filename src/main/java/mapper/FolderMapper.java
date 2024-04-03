package mapper;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.knowledge.internship.banksystem.dto.FolderDTO;
import gr.knowledge.internship.banksystem.entity.Folder;

@Component
public class FolderMapper {
	@Autowired
	ModelMapper modelMapper;

	public Folder toFolder(FolderDTO folderDTO) {
		return modelMapper.map(folderDTO, Folder.class);
	}

	public FolderDTO toFolderDTO(Folder folder) {
		return modelMapper.map(folder, FolderDTO.class);
	}

	public List<Folder> toFolderList(List<FolderDTO> folderDTOList) {
		List<Folder> folderList = Collections.emptyList();
		for (FolderDTO folderDTO : folderDTOList) {
			Folder folderToAdd = modelMapper.map(folderDTO, Folder.class);
			folderList.add(folderToAdd);
		}
		return folderList;
	}

	public List<FolderDTO> toFolderDTOList(List<Folder> folderList) {
		List<FolderDTO> folderDTOList = Collections.emptyList();
		for (Folder folder : folderList) {
			FolderDTO folderDTOToAdd = modelMapper.map(folder, FolderDTO.class);
			folderDTOList.add(folderDTOToAdd);
		}
		return folderDTOList;
	}
}
