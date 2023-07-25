package com.example.demo.dto;


import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class LeadDetailDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private List<ConsultantDetailsDTO> consultantList;
}