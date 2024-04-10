package gr.knowledge.internship.banksystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneDTO implements Serializable {
    private Long id;

    private CodedTypeDTO phoneType;

    private String phoneNumber;

    private String registryAfm;
}
