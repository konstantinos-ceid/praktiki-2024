package gr.knowledge.internship.banksystem.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankRegistryDTO {
    private Integer id;
    private String name;
    private String surname;
    private String fathers_name;
    private String fathers_surname;
    private String mothers_name;
    private String mothers_surname;
    private Date date_of_birth;
    private String place_of_birth;
    private String afm;
    private String amka;
    private String iban;
    private Integer bank_id;
    private Integer sector_id;
}
