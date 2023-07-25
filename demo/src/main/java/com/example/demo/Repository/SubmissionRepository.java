package com.example.demo.Repository;


import com.example.demo.dto.SubmissionDTO;
import com.example.demo.Service.ISubmissionService;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SubmissionRepository implements ISubmissionRepository {

    public  HashMap<String, SubmissionDTO> submissions = new HashMap<>();

    @Override
    public SubmissionDTO createSubmission(SubmissionDTO submissionDTO) {
        submissions.put(submissionDTO.getId(), submissionDTO);
        return submissionDTO;
    }

    public List<SubmissionDTO> getBySalesPersonName(String salesPersonName){
        return submissions.values()
                .stream()
                .filter(s -> s.getSalesPersonName().equals(salesPersonName))
                .collect(Collectors.toList());
    }


    @Override
    public SubmissionDTO getSubmissionById(String id) {
        return submissions.get(id);
    }

    public  boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
