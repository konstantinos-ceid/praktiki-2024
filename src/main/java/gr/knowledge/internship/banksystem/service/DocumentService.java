package gr.knowledge.internship.banksystem.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.knowledge.internship.banksystem.dto.DocumentDTO;
import gr.knowledge.internship.banksystem.entity.Document;
import gr.knowledge.internship.banksystem.repository.DocumentRepository;

@Service
@Transactional
public class DocumentService {
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	public DocumentDTO getDocumentById(Long id) {
		Document document = documentRepository.getReferenceById(id);
		return modelMapper.map(document, DocumentDTO.class);
	}

	@Transactional(readOnly = true)
	public List<DocumentDTO> getAllDocuments() {
		List<Document> allDocument = documentRepository.findAll();
		return modelMapper.map(allDocument, new TypeToken<List<DocumentDTO>>() {
		}.getType());
	}

	public DocumentDTO saveDocument(DocumentDTO documentDTO) {
		Document documentToSave = modelMapper.map(documentDTO, Document.class);
		documentRepository.save(documentToSave);
		return modelMapper.map(documentToSave, DocumentDTO.class);
	}

	public DocumentDTO updateDocument(DocumentDTO documentDTO) {
		Document documentToUpdate = modelMapper.map(documentDTO, Document.class);
		documentRepository.save(documentToUpdate);
		return modelMapper.map(documentToUpdate, DocumentDTO.class);
	}

	public void deleteDocument(DocumentDTO documentDTO) {
		Document documentToDelete = modelMapper.map(documentDTO, Document.class);
		documentRepository.delete(documentToDelete);
	}
}
