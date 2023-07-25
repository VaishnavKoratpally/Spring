package com.example.demo.dto;


import lombok.Data;

@Data
public class SubmissionDTO {
    private String id;
    private  String consultantName;
    private  String submissionDate;
    private  String leadName;
    private  String vendorName;
    private  Integer rate;
    private  String salesPersonName;
    private  String technology;
}