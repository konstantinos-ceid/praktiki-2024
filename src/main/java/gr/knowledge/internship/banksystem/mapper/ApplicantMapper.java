package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.ApplicantDTO;
import gr.knowledge.internship.banksystem.entity.Applicant;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicantMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ApplicantMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    public ApplicantDTO toDTO(Applicant applicant){
        return modelMapper.map(applicant, new TypeToken<ApplicantDTO>(){}.getType());
    }

    public Applicant toEntity(ApplicantDTO applicantDTO){
        return modelMapper.map(applicantDTO, Applicant.class);
    }

    public List<ApplicantDTO> toDTOList(List<Applicant> applicantList){
        return modelMapper.map(applicantList, new TypeToken<List<ApplicantDTO>>(){}.getType());
    }

    public List<Applicant> toEntityList(List<ApplicantDTO> applicantDTOList){
        return modelMapper.map(applicantDTOList, new TypeToken<List<Applicant>>(){}.getType());
    }
}
