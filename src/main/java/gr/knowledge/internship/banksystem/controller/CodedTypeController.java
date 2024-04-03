package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.Dto.CodedTypeDto;
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
    public List<CodedTypeDto> getAllCodedTypes() {
        return codedTypeService.getAllCodedTypes();
    }

    @GetMapping("/{id}")
    public CodedTypeDto getCodedTypeById(@PathVariable Long id) {
        return codedTypeService.getCodedTypeById(id);
    }

    @PostMapping
    public CodedTypeDto createCodedType(@RequestBody CodedTypeDto codedTypeDto) {
        return codedTypeService.saveCodedType(codedTypeDto);
    }

    @PutMapping
    public CodedTypeDto updateCodedType(@RequestBody CodedTypeDto codedTypeDto) {
        return codedTypeService.saveCodedType(codedTypeDto);
    }

    @DeleteMapping
    public String deleteCodedType(@RequestBody CodedTypeDto codedTypeDto) {
        return codedTypeService.deleteCodedType(codedTypeDto);
    }

}
