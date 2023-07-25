package com.example.demo.Service;



import com.example.demo.dto.SubmissionDTO;

public interface ISubmissionService {

    SubmissionDTO createSubmission(SubmissionDTO submission);

    SubmissionDTO getSubmissionById(String id);

}