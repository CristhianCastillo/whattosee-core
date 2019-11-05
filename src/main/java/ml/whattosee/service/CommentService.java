package ml.whattosee.service;

import ml.whattosee.dto.CommentDto;
import ml.whattosee.model.CommentEntity;
import ml.whattosee.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class CommentService {

    @Autowired
    private CommentRepository service;

    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public CommentDto save(CommentDto commentDto) {
        commentDto.setCreation(new Date());
        CommentEntity commentEntity = modelMapper.map(commentDto, CommentEntity.class);
        return modelMapper.map(service.save(commentEntity), CommentDto.class);
    }
}
