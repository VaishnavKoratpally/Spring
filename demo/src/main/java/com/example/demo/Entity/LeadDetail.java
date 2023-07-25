package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="lead_detail")
@Data
public class LeadDetail {
    @Column(name="id")
    @Id
    private long id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy="leadDetail", cascade = CascadeType.ALL)
    private List<ConsultantDetail> consultantList;
}
