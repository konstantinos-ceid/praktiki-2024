package gr.knowledge.internship.banksystem.dto;

import gr.knowledge.internship.banksystem.entity.Applicant;
import gr.knowledge.internship.banksystem.entity.CodedType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovementDTO {
    private Long id;
    private BigDecimal numeric;
    private LocalDate movementDate;
    private ApplicantDTO applicant;
    private CodedTypeDTO movementType;

}
