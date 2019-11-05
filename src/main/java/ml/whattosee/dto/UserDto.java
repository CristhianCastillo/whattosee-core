package ml.whattosee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String email;
    private String userName;
    private String password;
    private String token;
    private RolDto rolEntity;

    public UserDto() {

    }

    public UserDto(Long id, String email, String userName, String password, RolDto rolEntity, String token) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.token = token;
        this.rolEntity = rolEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolDto getRolEntity() {
        return rolEntity;
    }

    public void setRolEntity(RolDto rolEntity) {
        this.rolEntity = rolEntity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
