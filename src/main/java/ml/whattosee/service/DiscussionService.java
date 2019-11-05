package ml.whattosee.service;

import ml.whattosee.dto.CommentDiscussionDto;
import ml.whattosee.dto.DiscussionDto;
import ml.whattosee.model.CommentDiscussionEntity;
import ml.whattosee.model.DiscussionEntity;
import ml.whattosee.repository.CommentDiscussionRepository;
import ml.whattosee.repository.DiscussionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository service;

    @Autowired
    private CommentDiscussionRepository commentDiscussionRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public DiscussionDto save(DiscussionDto discussionDto) {
        discussionDto.setCreation(new Date());
        DiscussionEntity discussionEntity = modelMapper.map(discussionDto, DiscussionEntity.class);
        return modelMapper.map(service.save(discussionEntity), DiscussionDto.class);
    }

    @Transactional
    public CommentDiscussionDto saveComment(CommentDiscussionDto commentDiscussionDto) {
        commentDiscussionDto.setCreation(new Date());
        CommentDiscussionEntity commentDiscussionEntity = modelMapper.map(commentDiscussionDto, CommentDiscussionEntity.class);
        return modelMapper.map(commentDiscussionRepository.save(commentDiscussionEntity), CommentDiscussionDto.class);
    }

}
