package ml.whattosee.controller;

import ml.whattosee.dto.CommentDto;
import ml.whattosee.service.CommentService;
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
public class CommentController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping(EndPointsConstant.REST_POST_COMMENTS)
    public ResponseDto createComment(@RequestBody CommentDto commentDto) {
        try {
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), commentService.save(commentDto));
        } catch (Exception ex) {
            LOGGER.error("ERROR CREATING COMMENT: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_CREATING_COMMENT.getCode(), ex.getMessage());
        }
    }
}
