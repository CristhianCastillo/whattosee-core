package ml.whattosee.service;

import ml.whattosee.dto.RolDto;
import ml.whattosee.model.RolEntity;
import ml.whattosee.repository.RolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository service;

    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public List<RolDto> findAll() {
        List<RolDto> roles = new ArrayList<>();
        service.findAll().forEach(e -> roles.add(modelMapper.map(e, RolDto.class)));
        return roles;
    }

    @Transactional
    public RolDto findByName(String name) {
        RolEntity rolEntity = service.findByName(name);
        return modelMapper.map(rolEntity, RolDto.class);
    }

}
