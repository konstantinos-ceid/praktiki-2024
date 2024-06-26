package gr.knowledge.internship.banksystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_id_seq")
    @SequenceGenerator(name = "bank_id_seq", sequenceName = "bank_id_seq", allocationSize = 50, initialValue = 1)
    @NotNull
    private Long id;

    @NotNull
    @Size(max=50)
    @Column(name="name")
    private String name;

    @NotNull
    @Size(max=50)
    @Column(name="address")
    private String address;

}
