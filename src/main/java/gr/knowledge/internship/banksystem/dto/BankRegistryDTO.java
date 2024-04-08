package gr.knowledge.internship.banksystem.dto;

import gr.knowledge.internship.banksystem.entity.Bank;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankRegistryDTO implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String fathersName;
    private String fathersSurname;
    private String mothersName;
    private String mothersSurname;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String afm;
    private String amka;
    private String iban;
    private BankDTO bank;
    private CodedTypeDTO sector;
}
