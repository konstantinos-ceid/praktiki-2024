package mapper;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.knowledge.internship.banksystem.dto.DocumentDTO;
import gr.knowledge.internship.banksystem.entity.Document;

@Component
public class DocumentMapper {
	@Autowired
	ModelMapper modelMapper;

	public Document toDocument(DocumentDTO documentDTO) {
		return modelMapper.map(documentDTO, Document.class);
	}

	public DocumentDTO toDocumentDTO(Document document) {
		return modelMapper.map(document, DocumentDTO.class);
	}

	public List<Document> toDocumentList(List<DocumentDTO> documentDTOList) {
		List<Document> documentList = Collections.emptyList();
		for (DocumentDTO documentDTO : documentDTOList) {
			Document documentToAdd = modelMapper.map(documentDTO, Document.class);
			documentList.add(documentToAdd);
		}
		return documentList;
	}

	public List<DocumentDTO> toDocumentDTOList(List<Document> documentList) {
		List<DocumentDTO> documentDTOList = Collections.emptyList();
		for (Document document : documentList) {
			DocumentDTO documentDTOToAdd = modelMapper.map(document, DocumentDTO.class);
			documentDTOList.add(documentDTOToAdd);
		}
		return documentDTOList;
	}
}
