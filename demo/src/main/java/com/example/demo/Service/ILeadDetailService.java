package com.example.demo.Service;


import com.example.demo.Entity.LeadDetail;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ILeadDetailService {

    List<LeadDetail> getAllLeads();

    LeadDetail addLead(@RequestBody LeadDetail lead);

}