package com.example.demo.Service;


import com.example.demo.dto.SubmissionDTO;
import com.example.demo.Resource.SubmissionResource;
import com.example.demo.Repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class SubmissionServiceImpl implements ISubmissionService{

    @Autowired
    private SubmissionRepository repository;
    @Override
    public SubmissionDTO createSubmission(SubmissionDTO submission) {
        String id = UUID.randomUUID().toString();
        submission.setId(id);
        // store it
        return repository.createSubmission(submission);
    }

    @Override
    public SubmissionDTO getSubmissionById(String id) {
        SubmissionDTO dto = repository.getSubmissionById(id);
        return  dto;
    }
}

