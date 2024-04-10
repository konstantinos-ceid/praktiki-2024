package gr.knowledge.internship.banksystem.mapper;

import gr.knowledge.internship.banksystem.dto.PhoneDTO;
import gr.knowledge.internship.banksystem.entity.Phone;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhoneMapper {
    @Autowired
    private ModelMapper modelMapper;


 //This was not necessary
   // @Autowired
  //  private BankMapper bankMapper;

    public List<Phone> toEntityList(List<PhoneDTO> phoneDTOs){
       return  modelMapper.map(phoneDTOs,new TypeToken<List<Phone>>(){}.getType());
    }

    public List<PhoneDTO> toDTOList(List<Phone> phones){
        return  modelMapper.map(phones,new TypeToken<List<PhoneDTO>>(){}.getType());
    }

    public Phone toEntity(PhoneDTO phoneDTO){
        return modelMapper.map(phoneDTO,Phone.class);
    }

    public PhoneDTO toDTO(Phone phone){
        return modelMapper.map(phone,PhoneDTO.class);
    }
}
