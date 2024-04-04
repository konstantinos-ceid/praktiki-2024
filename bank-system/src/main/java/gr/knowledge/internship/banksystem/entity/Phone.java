package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_id_seq")
    @SequenceGenerator(name = "phone_id_seq", sequenceName = "phone_id_seq", allocationSize = 50, initialValue = 1)
    @NotNull
    private Long id;
// foreign key

    @ManyToOne
    @JoinColumn(name = "phone_type", referencedColumnName = "id")
    private CodedType phoneType;

    @NotNull
    @Size(max=10)
    @Column(name="phone_number")
    private String phoneNumber;


    @NotNull
    @Size(max=20)
    @Column(name="registry_afm")
    private String registryAfm;
}
