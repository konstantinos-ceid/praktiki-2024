package gr.knowledge.internship.banksystem.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.knowledge.internship.banksystem.dto.DocumentDTO;
import gr.knowledge.internship.banksystem.entity.Document;

@Component
public class DocumentMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Document toEntity(DocumentDTO documentDTO) {
		return modelMapper.map(documentDTO, Document.class);
	}

	public DocumentDTO toDTO(Document document) {
		return modelMapper.map(document, DocumentDTO.class);
	}

	public List<Document> toEntityList(List<DocumentDTO> documentDTOList) {
		List<Document> documentList = new ArrayList<Document>();
		for (DocumentDTO documentDTO : documentDTOList) {
			Document documentToAdd = modelMapper.map(documentDTO, Document.class);
			documentList.add(documentToAdd);
		}
		return documentList;
	}

	public List<DocumentDTO> toDTOList(List<Document> documentList) {
		List<DocumentDTO> documentDTOList = new ArrayList<DocumentDTO>();
		for (Document document : documentList) {
			DocumentDTO documentDTOToAdd = modelMapper.map(document, DocumentDTO.class);
			documentDTOList.add(documentDTOToAdd);
		}
		return documentDTOList;
	}
}
