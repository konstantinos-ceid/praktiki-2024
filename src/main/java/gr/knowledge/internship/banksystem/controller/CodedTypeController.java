package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.dto.CodedTypeDTO;
import gr.knowledge.internship.banksystem.service.CodedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/coded-types")
public class CodedTypeController {

    @Autowired
    private CodedTypeService codedTypeService;

    @GetMapping
    public List<CodedTypeDTO> getAllCodedTypes() {
        return codedTypeService.getAllCodedTypes();
    }

    @GetMapping("/{id}")
    public CodedTypeDTO getCodedTypeById(@PathVariable Long id) {
        return codedTypeService.getCodedTypeById(id);
    }

    @PostMapping
    public CodedTypeDTO createCodedType(@RequestBody CodedTypeDTO codedTypeDto) {
        return codedTypeService.saveCodedType(codedTypeDto);
    }

    @PutMapping("/{id}")
    public CodedTypeDTO updateCodedType(@RequestBody CodedTypeDTO codedTypeDto, @PathVariable Long id) {
        return codedTypeService.updateCodedType(codedTypeDto, id);
    }

    @DeleteMapping
    public void deleteCodedType(@RequestBody CodedTypeDTO codedTypeDto) {
        codedTypeService.deleteCodedType(codedTypeDto);
    }

}
