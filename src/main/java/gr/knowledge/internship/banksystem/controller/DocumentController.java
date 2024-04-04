package gr.knowledge.internship.banksystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.knowledge.internship.banksystem.dto.DocumentDTO;
import gr.knowledge.internship.banksystem.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private DocumentService documentService;

	@GetMapping("/{id}")
	public DocumentDTO getDocumentById(@PathVariable Long id) {
		return documentService.getDocumentById(id);
	}

	@GetMapping
	public List<DocumentDTO> getAllDocuments() {
		return documentService.getAllDocuments();
	}

	@PostMapping("/save")
	public DocumentDTO saveDocument(@RequestBody DocumentDTO document) {
		return documentService.saveDocument(document);
	}

	@PutMapping("/update")
	public DocumentDTO updateDocument(@RequestBody DocumentDTO document) {
		return documentService.updateDocument(document);
	}

	@DeleteMapping("/delete")
	public void deleteDocument(@RequestBody DocumentDTO document) {
		documentService.deleteDocument(document);
	}
}