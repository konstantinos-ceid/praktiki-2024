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

import gr.knowledge.internship.banksystem.dto.FolderDTO;
import gr.knowledge.internship.banksystem.service.FolderService;

@RestController
@RequestMapping(value = "/folder")
public class FolderController {
	@Autowired
	private FolderService folderService;

	@GetMapping
	public List<FolderDTO> getAllFolders() {
		return folderService.getAllFolders();
	}

	@GetMapping("/{id}")
	public FolderDTO getFolderById(@PathVariable Long id) {
		return folderService.getFolderById(id);
	}

	@PostMapping("/save")
	public FolderDTO saveFolder(@RequestBody FolderDTO folder) {
		return folderService.saveFolder(folder);
	}

	@PutMapping("/update")
	public FolderDTO updateFolder(@RequestBody FolderDTO folder) {
		return folderService.updateFolder(folder);
	}

	@DeleteMapping("/delete")
	public void deleteFolder(@RequestBody FolderDTO folder) {
		folderService.deleteFolder(folder);
	}
}
