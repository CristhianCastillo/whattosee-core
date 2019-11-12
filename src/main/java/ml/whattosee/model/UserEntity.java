package ml.whattosee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "email", unique = true)
    private String email;
    @Column(nullable = false, name = "user_name", unique = true)
    private String userName;
    @JsonIgnore
    @Column(nullable = false, name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(nullable = true, name = "rol_id")
    private RolEntity rolEntity;

    public UserEntity() {
    }

    public UserEntity(Long id, String email, String userName, String password, RolEntity rolEntity) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
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

    public RolEntity getRolEntity() {
        return rolEntity;
    }

    public void setRolEntity(RolEntity rolEntity) {
        this.rolEntity = rolEntity;
    }
}
