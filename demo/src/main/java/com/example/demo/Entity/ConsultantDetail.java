package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ConsultantDetail {
    @Id
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lead_id")
    private LeadDetail leadDetail;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
}
