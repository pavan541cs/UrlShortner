package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    @Column(name = "creation_date")
    private Date creationDate;
    @OneToMany(mappedBy = "user")
    private List<ShortLink> shortLinks = new LinkedList<>();
}