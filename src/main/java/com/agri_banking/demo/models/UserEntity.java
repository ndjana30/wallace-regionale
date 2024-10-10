package com.agri_banking.demo.models;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;
    private String nationality;
    private String profession;
    private String residence;
    private String phoneNum;
    private Date dateOfBirth;
    private Boolean active=true;

    @OneToMany(mappedBy = "proprietor")
    private List<Project> projects = new ArrayList<>();
    @JsonManagedReference(value = "projects-user")
    public List<Project> getProjects() {
        return projects;
    }

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
    private List<Role> roles =  new ArrayList<>();

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

