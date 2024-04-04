package gr.knowledge.internship.banksystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.knowledge.internship.banksystem.dto.DocumentDTO;
import gr.knowledge.internship.banksystem.entity.Document;
import gr.knowledge.internship.banksystem.mapper.DocumentMapper;
import gr.knowledge.internship.banksystem.repository.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 * This class provides services for managing documents in the bank system.
 */
@Service
@Transactional
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private DocumentMapper documentMapper;

	/**
	 * Retrieves a document by its ID.
	 *
	 * @param id The ID of the document to retrieve.
	 * @return The DTO representation of the document.
	 * @throws EntityNotFoundException If the document with the given ID is not
	 *                                 found.
	 */
	@Transactional(readOnly = true)
	public DocumentDTO getDocumentById(Long id) {
		Document document = documentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		return documentMapper.toDTO(document);
	}

	/**
	 * Retrieves all documents.
	 *
	 * @return A list of DTO representations of all documents.
	 */
	@Transactional(readOnly = true)
	public List<DocumentDTO> getAllDocuments() {
		List<Document> allDocument = documentRepository.findAll();
		return documentMapper.toDTOList(allDocument);
	}

	/**
	 * Saves a new document.
	 *
	 * @param documentDTO The DTO representation of the document to be saved.
	 * @return The DTO representation of the saved document.
	 */
	public DocumentDTO saveDocument(DocumentDTO documentDTO) {
		Document document = documentMapper.toEntity(documentDTO);
		documentRepository.save(document);
		return documentMapper.toDTO(document);
	}

	/**
	 * Updates an existing document.
	 *
	 * @param documentDTO The DTO representation of the document to be updated.
	 * @return The DTO representation of the updated document.
	 */
	public DocumentDTO updateDocument(DocumentDTO documentDTO) {
		Document document = this.existsInDatabase(documentDTO);
		document = documentMapper.toEntity(documentDTO);
		documentRepository.save(document);
		return documentDTO;
	}

	/**
	 * Deletes a document.
	 *
	 * @param documentDTO The DTO representation of the document to be deleted.
	 */
	public void deleteDocument(DocumentDTO documentDTO) {
		Document document = documentMapper.toEntity(documentDTO);
		documentRepository.delete(document);
	}

	private Document existsInDatabase(DocumentDTO documentDTO) {
		Document documentInDatabase = documentRepository.findById(documentDTO.getId())
				.orElseThrow(EntityNotFoundException::new);
		return documentInDatabase;
	}
}
