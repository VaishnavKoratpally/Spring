package com.example.demo.Resource;

import com.example.demo.dto.LeadDetailDTO;
import com.example.demo.dto.ConsultantDetailsDTO;
import com.example.demo.Entity.ConsultantDetail;
import com.example.demo.Entity.LeadDetail;

import com.example.demo.Service.ILeadDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping("/leads")

public class LeadDetailResource {

    @Autowired
    private ILeadDetailService service;

    @GetMapping
    public List<LeadDetailDTO> getAllLeads() {
        List<LeadDetail> leadDetails = service.getAllLeads();
        return leadDetails.stream().map(
                entity -> mapToDto(entity)
        ).collect(Collectors.toList());
    }

    @PostMapping
    public LeadDetail addLead(@RequestBody LeadDetail lead) {

        return service.addLead(lead);
    }

    private static LeadDetailDTO mapToDto(LeadDetail entity) {
        LeadDetailDTO dto = new LeadDetailDTO();
        dto.setId(entity.getId());
//        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setConsultantList(entity.getConsultantList().stream().map(
                consultantDetail -> {
                    ConsultantDetailsDTO cDto = new ConsultantDetailsDTO();
                    cDto.setId(consultantDetail.getId());
                    cDto.setLeadId(entity.getId());
                    cDto.setFirstName(consultantDetail.getFirstName());
                    cDto.setLastName(consultantDetail.getLastName());
                    cDto.setEmailAddress(consultantDetail.getEmailAddress());
                    cDto.setPhoneNumber(consultantDetail.getPhoneNumber());
                    return cDto;
                }
        ).collect(Collectors.toList()));
        return dto;
    }
}
