package ml.whattosee.controller;

import ml.whattosee.dto.CommentDiscussionDto;
import ml.whattosee.dto.DiscussionDto;
import ml.whattosee.service.DiscussionService;
import ml.whattosee.util.CodeErrorResponse;
import ml.whattosee.util.CodeResponse;
import ml.whattosee.util.EndPointsConstant;
import ml.whattosee.util.ResponseDto;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiscussionController {

    public static final Logger LOGGER = LoggerFactory.getLogger(DiscussionController.class);

    @Autowired
    private DiscussionService discussionService;

    @ResponseBody
    @PostMapping(EndPointsConstant.REST_POST_DISCUSSIONS)
    public ResponseDto create(@RequestBody DiscussionDto discussionDto) {
        try {
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), discussionService.save(discussionDto));
        } catch (Exception ex) {
            LOGGER.error("ERROR CREATING DISCUSSION: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_CREATING_DISCUSSION.getCode(), ex.getMessage());
        }
    }

    @ResponseBody
    @PostMapping(EndPointsConstant.REST_POST_DISCUSSIONS_COMMENT)
    public ResponseDto create(@RequestBody CommentDiscussionDto commentDiscussionDto) {
        try {
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), discussionService.saveComment(commentDiscussionDto));
        } catch (Exception ex) {
            LOGGER.error("ERROR CREATING COMMENT DISCUSSION: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_CREATING_DISCUSSION_COMMENT.getCode(), ex.getMessage());
        }
    }
}
