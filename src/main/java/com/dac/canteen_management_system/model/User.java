package com.dac.canteen_management_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "username")
    private String userName;

    @NonNull
    @Column(name = "password")
    @JsonProperty("password")
    private String password;

    @NonNull
    @Column(name = "mobileno")
    @Range(min = 10, max = 10)
    private long mobileNo;

    @Column(name = "created_at")
    private Timestamp created_at;
}
