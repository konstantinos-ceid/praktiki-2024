package gr.knowledge.internship.banksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDTO implements Serializable {
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
    private FolderDTO folder;   

    @Override
    public String toString() {
        return "ApplicantDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", fathersSurname='" + fathersSurname + '\'' +
                ", mothersName='" + mothersName + '\'' +
                ", mothersSurname='" + mothersSurname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", afm='" + afm + '\'' +
                ", amka='" + amka + '\'' +
                ", iban='" + iban + '\'' +
                ", folderId=" + folderId +
                '}';
    }
}
