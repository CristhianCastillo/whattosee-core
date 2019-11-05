package ml.whattosee.service;

import ml.whattosee.cofig.JwtTokenUtil;
import ml.whattosee.dto.UserDto;
import ml.whattosee.model.UserEntity;
import ml.whattosee.repository.UserRepository;
import ml.whattosee.util.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    public static final String COMMON_USER = "normal";
    public static final String ADMINITRATION_USER = "user-master";

    @Autowired
    private UserRepository service;

    @Autowired
    private RolService rolService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public UserDto findByUserNameOrEmail(String userName, String email) {
        UserEntity userEntity = service.findByUserNameOrEmail(userName, email);
        if (userEntity != null)
            return modelMapper.map(userEntity, UserDto.class);
        else
            return null;
    }

    @Transactional
    public UserDto findByUserName(String userName) {
        final UserDetails userDetails = loadUserByUsername(userName);
        final String token = jwtTokenUtil.generateToken(userDetails);
        UserEntity userEntity = service.findByUserName(userName);
        if (userEntity != null) {
            UserDto userDto = modelMapper.map(userEntity, UserDto.class);
            userDto.setToken(token);
            return userDto;
        }
        else
            return null;
    }

    @Transactional
    public UserDto save(UserDto userDto, String type) {
        userDto.setRolEntity(rolService.findByName(type));
        String passwordHash = SecurityUtils.hashPassword(userDto.getPassword());
        userDto.setPassword(passwordHash);
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userEntity = service.save(userEntity);
        if (userEntity != null)
            return modelMapper.map(userEntity, UserDto.class);
        else
            return null;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = service.findByUserName(userName);
        if (userEntity != null)
            return new org.springframework.security.core.userdetails.User(userEntity.getUserName(), userEntity.getPassword(),
                    new ArrayList<>());
        else
            throw new UsernameNotFoundException("User not found with username: " + userName);
    }
}
