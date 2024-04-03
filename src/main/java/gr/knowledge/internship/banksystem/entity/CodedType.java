package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "coded_type")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class CodedType {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coded_type_sequence")
    @SequenceGenerator(
            name = "coded_type_sequence",
            sequenceName = "coded_type_sequence",
            allocationSize = 50,
            initialValue = 1
    )
    private Long id;

    @Column(name = "code") @Size(max = 255)
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "reference_id")
    private CodedType codedType;
}
