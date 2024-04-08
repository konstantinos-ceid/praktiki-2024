package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicant")
public class Applicant implements Serializable {
    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "applicant_id_sequence")
    @SequenceGenerator(name = "applicant_id_sequence", sequenceName = "applicant_id_sequence")
    @NotNull
    private long id;

    @Size(max = 50) @Column(name = "name")
    private String name;

    @Size(max = 50) @Column(name = "surname")
    private String surname;

    @Size(max = 50) @Column(name = "fathers_name")
    private String fathersName;

    @Size(max = 50) @Column(name = "fathers_surname")
    private String fathersSurname;

    @Size(max = 50) @Column(name = "mothers_name")
    private String mothersName;

    @Size(max = 50) @Column(name = "mothers_surname")
    private String mothersSurname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Size(max = 50) @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Size(max = 20) @Column(name = "afm")
    private String afm;

    @Size(max = 20) @Column(name = "amka")
    private String amka;

    @Size(max = 50) @Column(name = "iban")
    private String iban;

    @JoinColumn(name = "folder_id")
    @ManyToOne
    @NotNull
    private Folder folder;

    @Override
    public String toString(){
return "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fathers_name='" + fathersName + '\'' +
                ", fathers_surname='" + fathersSurname + '\'' +
                ", mothers_name='" + mothersName + '\'' +
                ", mothers_surname='" + mothersSurname + '\'' +
                ", date_of_birth=" + dateOfBirth +
                ", place_of_birth='" + placeOfBirth + '\'' +
                ", afm='" + afm + '\'' +
                ", amka='" + amka + '\'' +
                ", iban='" + iban + '\'' +
                ", folderx=" + folder +
                '}';
    }
}
