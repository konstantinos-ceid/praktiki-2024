package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_registry")
public class BankRegistry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_registry_sequence")
    @SequenceGenerator(name = "bank_registry_sequence", sequenceName = "bank_registry_sequence", allocationSize = 50)
    @NotNull
    private Long id;

    @Column(name = "name")
    @Size(max = 50)
    @NotNull
    private String name;

    @Column(name = "surname")
    @Size(max = 50)
    @NotNull
    private String surname;

    @Column(name = "fathers_name")
    @Size(max = 50)
    @NotNull
    private String fathersName;

    @Column(name = "fathers_surname")
    @Size(max = 50)
    @NotNull
    private String fathersSurname;

    @Column(name = "mothers_name")
    @Size(max = 50)
    @NotNull
    private String mothersName;

    @Column(name = "mothers_surname")
    @Size(max = 50)
    @NotNull
    private String mothersSurname;

    @Column(name = "date_of_birth")
    @NotNull
    private Date dateOfBirth;

    @Column(name = "place_of_birth")
    @Size(max = 50)
    @NotNull
    private String placeOfBirth;

    @Column(name = "afm")
    @Size(max = 20)
    @NotNull
    private String afm;

    @Column(name = "amka")
    @Size(max = 20)
    @NotNull
    private String amka;

    @Column(name = "iban")
    @Size(max = 50)
    @NotNull
    private String iban;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToOne
    @JoinColumn(name = "sector_id")
    private CodedType codedType;
}