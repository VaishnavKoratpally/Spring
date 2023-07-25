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
//        lead.setFirstName(lead.getFirstName());
        lead.setLastName(leadDetails.getLastName());
        lead.setEmailAddress(leadDetails.getEmailAddress());
        lead.setPhoneNumber(leadDetails.getPhoneNumber());

        return lead;

    }

    public LeadDetail addLead(LeadDetail lead) {

        return repository.save(lead);
    }




    public String  deleteLead(long id) {
        repository.deleteById(id);
        return "Success";
    }

    public LeadDetail getLeadById(long id) {

        return repository.findById(id).get();
    }
}