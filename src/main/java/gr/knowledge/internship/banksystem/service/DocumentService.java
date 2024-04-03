package gr.knowledge.internship.banksystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.knowledge.internship.banksystem.dto.DocumentDTO;
import gr.knowledge.internship.banksystem.entity.Document;
import gr.knowledge.internship.banksystem.repository.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;
import gr.knowledge.internship.banksystem.mapper.DocumentMapper;


@Service
@Transactional
public class DocumentService {
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private DocumentMapper documentMapper;

	@Transactional(readOnly = true)
	public DocumentDTO getDocumentById(Long id) {
		Document document = documentRepository.getReferenceById(id);
		return documentMapper.toDocumentDTO(document);
	}

	@Transactional(readOnly = true)
	public List<DocumentDTO> getAllDocuments() {
		List<Document> allDocument = documentRepository.findAll();
		return documentMapper.toDocumentDTOList(allDocument);
	}

	public DocumentDTO saveDocument(DocumentDTO documentDTO) {
		Document documentToSave = documentMapper.toDocument(documentDTO);
		documentRepository.save(documentToSave);
		return documentMapper.toDocumentDTO(documentToSave);
	}

	public DocumentDTO updateDocument(DocumentDTO documentDTO) {
		if (this.existsInDatabase(documentDTO)) {
			Document documentToSave = documentMapper.toDocument(documentDTO);
			documentRepository.save(documentToSave);
		}
		return documentDTO;
	}


	public void deleteDocument(DocumentDTO documentDTO) {
		Document documentToDelete = documentMapper.toDocument(documentDTO);
		documentRepository.delete(documentToDelete);
	}

	private boolean existsInDatabase(DocumentDTO documentDTO) {
		try {
//			TODO global EntityNotFoundException handler
			Document documentInDatabase = documentRepository.getReferenceById(documentDTO.getId());
			return documentInDatabase != null;
		} catch (NullPointerException npe) {
			throw new EntityNotFoundException("Null document ID given.");
		}
	}
}
