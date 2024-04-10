package gr.knowledge.internship.banksystem.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movement")
public class Movement implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_movement")
    @SequenceGenerator(name = "seq_movement", sequenceName = "seq_movement", allocationSize = 50, initialValue = 1)
    private Long id;

    @Column(name="numeric")
    private BigDecimal numeric;

    @Column(name="movement_date")
    private LocalDate movementDate;

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "movement_type", referencedColumnName = "id")
    private CodedType movementType;

}
