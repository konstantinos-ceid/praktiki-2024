package gr.knowledge.internship.banksystem.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.knowledge.internship.banksystem.dto.FolderDTO;
import gr.knowledge.internship.banksystem.entity.Folder;

@Component
public class FolderMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Folder toEntity(FolderDTO folderDTO) {
		return modelMapper.map(folderDTO, Folder.class);
	}

	public FolderDTO toDTO(Folder folder) {
		return modelMapper.map(folder, FolderDTO.class);
	}

	public List<Folder> toEntityList(List<FolderDTO> folderDTOList) {
		List<Folder> folderList = new ArrayList<Folder>();
		for (FolderDTO folderDTO : folderDTOList) {
			Folder folderToAdd = modelMapper.map(folderDTO, Folder.class);
			folderList.add(folderToAdd);
		}
		return folderList;
	}

	public List<FolderDTO> toDTOList(List<Folder> folderList) {
		List<FolderDTO> folderDTOList = new ArrayList<FolderDTO>();
		for (Folder folder : folderList) {
			FolderDTO folderDTOToAdd = modelMapper.map(folder, FolderDTO.class);
			folderDTOList.add(folderDTOToAdd);
		}
		return folderDTOList;
	}
}
