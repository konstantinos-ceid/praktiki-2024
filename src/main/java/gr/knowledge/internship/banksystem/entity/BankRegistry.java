package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "bank_registry")
public class BankRegistry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_registry_sequence")
    @SequenceGenerator(name = "bank_registry_sequence", sequenceName = "bank_registry_sequence", allocationSize = 50)
    @NotNull
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    @Size(max = 50)
    private String name;
    @Column(
            name = "surname",
            nullable = false
    )
    @Size(max = 50)
    private String surname;
    @Column(
            name = "fathers_name",
            nullable = false
    )
    @Size(max = 50)
    private String fathers_name;
    @Column(
            name = "fathers_surname",
            nullable = false
    )
    @Size(max = 50)
    private String fathers_surname;
    @Column(
            name = "mothers_name",
            nullable = false
    )
    @Size(max = 50)
    private String mothers_name;
    @Column(
            name = "mothers_surname",
            nullable = false
    )
    @Size(max = 50)
    private String mothers_surname;
    @Column(
            name = "date_of_birth",
            nullable = false
    )
    private Date date_of_birth;
    @Column(
            name = "place_of_birth",
            nullable = false
    )
    @Size(max = 50)
    private String place_of_birth;
    @Column(
            name = "afm",
            nullable = false
    )
    @Size(max = 20)
    private String afm;
    @Column(
            name = "amka",
            nullable = false
    )
    @Size(max = 20)
    private String amka;
    @Column(
            name = "iban",
            nullable = false
    )
    @Size(max = 50)
    private String iban;
    @Column(
            name = "bank_id",
            nullable = false
    )
    private Integer bank_id;
    @Column(
            name = "sector_id",
            nullable = false
    )
    private Integer sector_id;
}
