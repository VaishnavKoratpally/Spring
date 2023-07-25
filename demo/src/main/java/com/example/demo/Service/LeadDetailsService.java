package com.example.demo.Service;


import com.example.demo.Entity.LeadDetail;
import com.example.demo.Repository.LeadDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LeadDetailsService implements ILeadDetailService{

    @Autowired
    private LeadDetailsRepository repository;
    @Override
    public List<LeadDetail> getAllLeads() {
        return repository.findAll();
    }

    public LeadDetail editLead(long id,LeadDetail leadDetails) {
        LeadDetail lead = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        lead.setId(leadDetails.getId());
        lead.setFirst_name(lead.getFirst_name());
        lead.setLast_name(leadDetails.getLast_name());
        lead.setEmail_address(leadDetails.getEmail_address());
        lead.setPhone_number(leadDetails.getPhone_number());

        return lead;

    }

    public LeadDetail addLead(LeadDetail lead) {

        return repository.save(lead);
    }




    public  String  deleteLead(long id) {
        repository.deleteById(id);
        return "Success";
    }

    public LeadDetail getLeadById(long id) {

        return repository.findById(id).get();
    }
}