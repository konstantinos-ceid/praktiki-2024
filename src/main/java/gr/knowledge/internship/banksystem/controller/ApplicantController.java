package gr.knowledge.internship.banksystem.controller;

import gr.knowledge.internship.banksystem.dto.ApplicantDTO;
import gr.knowledge.internship.banksystem.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    ApplicantController(ApplicantService applicantService){
        this.applicantService = applicantService;
    }

    @GetMapping
    public List<ApplicantDTO> getApplicants(){
        return applicantService.getApplicants();
    }

    @GetMapping("/{id}")
    public ApplicantDTO getApplicantById(@PathVariable int id){
        return applicantService.getApplicantById(id);
    }

    @PostMapping
    public ApplicantDTO createApplicant(@RequestBody ApplicantDTO applicantDTO){
        return applicantService.createApplicant(applicantDTO);
    }

    @PutMapping("/{id}")
    public ApplicantDTO updateApplicant(@PathVariable int id, @RequestBody ApplicantDTO applicantDTO){
        return applicantService.updateApplicant(id, applicantDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicant(@PathVariable int id){
        applicantService.deleteApplicant(id);
    }
}
