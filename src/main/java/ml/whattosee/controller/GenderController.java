package ml.whattosee.controller;

import ml.whattosee.service.GenderService;
import ml.whattosee.util.CodeErrorResponse;
import ml.whattosee.util.CodeResponse;
import ml.whattosee.util.EndPointsConstant;
import ml.whattosee.util.ResponseDto;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GenderController {

    public static final Logger LOGGER = LoggerFactory.getLogger(GenderController.class);

    @Autowired
    private GenderService genderService;

    @ResponseBody
    @GetMapping(EndPointsConstant.REST_GET_GENDERES)
    public ResponseDto getAll() {
        try {
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), genderService.findAll());
        } catch (Exception ex) {
            LOGGER.error("ERROR GET ALL GENDERS: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_GET_GENDERS.getCode(), ex.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(EndPointsConstant.REST_GET_GENDERES_ID + "/{id}")
    public ResponseDto getAll(@PathVariable Long id) {
        try {
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), genderService.findById(id));
        } catch (Exception ex) {
            LOGGER.error("ERROR GET ALL GENDERS: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_GET_GENDERS.getCode(), ex.getMessage());
        }
    }

}
