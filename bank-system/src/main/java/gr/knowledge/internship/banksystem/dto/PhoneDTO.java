package gr.knowledge.internship.banksystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneDTO {
    private long id;

    private Integer phone_type;

    private String phone_number;

    private String registry_afm;
}
