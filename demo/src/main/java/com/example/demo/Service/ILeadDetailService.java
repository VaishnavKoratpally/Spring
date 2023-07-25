package com.example.demo.Service;


import com.example.demo.Entity.LeadDetail;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ILeadDetailService {

    List<LeadDetail> getAllLeads();

    LeadDetail addLead(@RequestBody LeadDetail lead);

    String deleteLead(@PathVariable long id);

    LeadDetail editLead(long id,LeadDetail leadDetails);


}