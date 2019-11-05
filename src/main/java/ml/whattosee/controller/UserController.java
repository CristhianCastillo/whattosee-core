package ml.whattosee.controller;

import ml.whattosee.dto.JwtRequestDto;
import ml.whattosee.dto.UserDto;
import ml.whattosee.service.RolService;
import ml.whattosee.service.UserService;
import ml.whattosee.util.CodeErrorResponse;
import ml.whattosee.util.CodeResponse;
import ml.whattosee.util.EndPointsConstant;
import ml.whattosee.util.ResponseDto;
import ml.whattosee.util.SecurityUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RolService rolService;

    // TODO Delete this method.
    @ResponseBody
    @GetMapping("/roles/get")
    public ResponseDto getRoles() {
        return new ResponseDto(CodeResponse.OK_COMMON.getCode(), rolService.findAll());
    }

    @ResponseBody
    @PostMapping(EndPointsConstant.REST_CREATE_USER)
    public ResponseDto createUser(@RequestBody UserDto userDto) {
        try {
            if (userDto == null)
                throw new Exception("El usuario no puede estar vacio.");
            if (Strings.isBlank(userDto.getUserName()))
                throw new Exception("El nombre de usuario no puede estar vacio.");
            if (Strings.isBlank(userDto.getEmail()))
                throw new Exception("El correo electronico no puede estar vacio.");
            if (Strings.isBlank(userDto.getPassword()))
                throw new Exception("El password no puede estar vacio.");
            UserDto userValidation = userService.findByUserNameOrEmail(userDto.getUserName(), userDto.getEmail());
            if (userValidation != null)
                throw new Exception("Usuario con correo o nombre de usuario ya existe.");
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), userService.save(userDto, UserService.COMMON_USER));
        } catch (Exception ex) {
            LOGGER.error("ERROR CREATING USER: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_CREATING_USER.getCode(), ex.getMessage());
        }
    }

    @ResponseBody
    @PostMapping(EndPointsConstant.REST_LOGIN_USER)
    public ResponseDto loginUser(@RequestBody JwtRequestDto jwtRequestDto) {
        try {
            if (jwtRequestDto == null)
                throw new Exception("El usuario no puede estar vacio.");
            if (Strings.isBlank(jwtRequestDto.getUsername()))
                throw new Exception("El nombre de usuario no puede estar vacio.");
            if (Strings.isBlank(jwtRequestDto.getPassword()))
                throw new Exception("El password no puede estar vacio.");
            UserDto userLogin = userService.findByUserName(jwtRequestDto.getUsername());
            if (userLogin == null)
                throw new Exception(CodeErrorResponse.ERROR_LOGIN.getDescription());
            if (!userLogin.getPassword().equals(SecurityUtils.hashPassword(jwtRequestDto.getPassword())))
                throw new Exception(CodeErrorResponse.ERROR_LOGIN.getDescription());
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), userLogin);
        } catch (Exception ex) {
            LOGGER.error("ERROR LOGIN USER: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_LOGIN.getCode(), ex.getMessage());
        }
    }
}
