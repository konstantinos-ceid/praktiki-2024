package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.Dto.ApplicantDTO;
import gr.knowledge.internship.banksystem.entity.Applicant;
import gr.knowledge.internship.banksystem.mapper.ApplicantMapper;
import gr.knowledge.internship.banksystem.repository.ApplicantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Log4j2
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    /**
     * Constructor for the ApplicantService.
     *
     * @param applicantRepository the repository for accessing applicant data
     * @param applicantMapper the mapper for converting between Applicant and ApplicantDTO objects
     */
    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository, ApplicantMapper applicantMapper){
        this.applicantRepository = applicantRepository;
        this.applicantMapper =  applicantMapper;
    }

    /**
     * Retrieves all applicants.
     *
     * @return a list of ApplicantDTO objects
     */
    @Transactional(readOnly = true)
    public List<ApplicantDTO> getApplicants(){
        List<Applicant> applicantList = applicantRepository.findAll();
        return applicantMapper.toDTOList(applicantList);
    }

    /**
     * Retrieves an applicant by id.
     *
     * @param id the id of the applicant to retrieve
     * @return the ApplicantDTO object corresponding to the applicant with the given id
     */
    @Transactional(readOnly = true)
    public ApplicantDTO getApplicantById(long id){
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Applicant with id: " + id + " not found"));
        return applicantMapper.toDTO(applicant);
    }

    /**
     * Creates a new applicant.
     *
     * @param applicantDTO the ApplicantDTO object containing the data for the new applicant
     * @return the ApplicantDTO object that was created
     */
    public ApplicantDTO createApplicant(ApplicantDTO applicantDTO){
        Applicant applicant =  applicantMapper.toEntity(applicantDTO);
        log.info("Applicant object created: " + applicant);
        applicantRepository.save(applicant);
        return applicantDTO;
    }

    /**
     * Updates an existing applicant.
     *
     * @param id the id of the applicant to update
     * @param applicantDTO the ApplicantDTO object containing the updated data
     * @return the ApplicantDTO object that was updated
     */
    public ApplicantDTO updateApplicant(long id, ApplicantDTO applicantDTO){
        checkExistingApplicant(id, applicantDTO);
        applicantRepository.save(applicantMapper.toEntity(applicantDTO));
        return applicantDTO;
    }

    /**
     * Deletes an applicant by id.
     *
     * @param id the id of the applicant to delete
     */
    public void deleteApplicant(long id){
        applicantRepository.deleteById(id);
    }

    /**
     * Checks if an applicant with the given id exists and if the id in the request body matches the id in the path.
     *
     * @param id the id of the applicant to check
     * @param applicantDTO the ApplicantDTO object containing the data to check
     */
    private void checkExistingApplicant(long id, ApplicantDTO applicantDTO) {
        if(applicantDTO.getId() != id){
            throw new IllegalArgumentException("Id in request body does not match id in path");
        } else if (!applicantRepository.existsById(id)){
            throw new EntityNotFoundException("Applicant with id: " + id + " not found");
        }
    }
}
