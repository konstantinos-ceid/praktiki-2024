package gr.knowledge.internship.banksystem.Dto;

import gr.knowledge.internship.banksystem.entity.CodedType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CodedTypeDto {

    private Long id;
    private String code;
    private String description;
    private CodedType codedType;
}
