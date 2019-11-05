package ml.whattosee.service;

import ml.whattosee.dto.GenderDto;
import ml.whattosee.model.GenderEntity;
import ml.whattosee.repository.GenderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenderService {

    @Autowired
    private GenderRepository service;

    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public List<GenderDto> findAll() {
        List<GenderDto> genders = new ArrayList<>();
        service.findAll().forEach(e -> genders.add(modelMapper.map(e, GenderDto.class)));
        return genders;
    }

    @Transactional
    public GenderDto findById(Long id) {
        GenderEntity genderEntity = service.findById(id).get();
        if(genderEntity != null)
            return modelMapper.map(genderEntity, GenderDto.class);
        else
            return null;
    }

}
