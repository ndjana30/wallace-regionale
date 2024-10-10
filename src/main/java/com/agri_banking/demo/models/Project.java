package com.agri_banking.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "project")
@Entity
@Data
public class Project
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "project_medias", joinColumns = @JoinColumn(name="project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="media_id", referencedColumnName = "id"))
    private List<Media> mediaList=new ArrayList<>();
    private long proprietor_id;
    @ManyToOne
    @JoinColumn(name = "proprietor_id",insertable = false,updatable = false)
    private UserEntity proprietor;

    @JsonBackReference(value = "projects-user")
    public UserEntity getProprietor() {
        return proprietor;
    }


}
