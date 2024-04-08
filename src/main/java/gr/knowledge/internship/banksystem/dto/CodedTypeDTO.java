package gr.knowledge.internship.banksystem.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CodedTypeDTO implements Serializable {
    private Long id;
    private String code;
    private String description;
    private CodedTypeDTO codedType;
}
