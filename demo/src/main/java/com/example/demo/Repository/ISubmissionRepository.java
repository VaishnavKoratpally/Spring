package com.example.demo.Repository;


import com.example.demo.dto.SubmissionDTO;

public interface ISubmissionRepository {
    SubmissionDTO createSubmission(SubmissionDTO submissionDTO);

    SubmissionDTO getSubmissionById(String id);
}
