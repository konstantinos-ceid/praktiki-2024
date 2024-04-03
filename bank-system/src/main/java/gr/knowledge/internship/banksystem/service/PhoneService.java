package gr.knowledge.internship.banksystem.service;

import gr.knowledge.internship.banksystem.dto.PhoneDTO;
import gr.knowledge.internship.banksystem.entity.Phone;
import gr.knowledge.internship.banksystem.repository.PhoneRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<PhoneDTO> getPhones(){
        List<Phone> allPhones=phoneRepository.findAll();

        List<PhoneDTO> allPhonesDTO= modelMapper.map(allPhones,new TypeToken<List<PhoneDTO>>(){}.getType());

        return allPhonesDTO;
    }

    public PhoneDTO savePhone(PhoneDTO phoneDTO){
        Phone savedPhone =phoneRepository.save(modelMapper.map(phoneDTO, Phone.class));
        return phoneDTO;
    }

    public PhoneDTO updatePhone(PhoneDTO phoneDTO){
        Phone updatedPhone =phoneRepository.save(modelMapper.map(phoneDTO,Phone.class));
        return phoneDTO;
    }

    public boolean deletePhone(PhoneDTO phoneDTO) {
        phoneRepository.delete(modelMapper.map(phoneDTO, Phone.class));
        return true;
    }

    public PhoneDTO getPhoneById(Long id){
        Optional<Phone> bankOptional = phoneRepository.findById(id);

        PhoneDTO phoneDTO = modelMapper.map(bankOptional.get(), PhoneDTO.class);
        return phoneDTO;
    }





}
