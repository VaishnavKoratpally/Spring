package com.example.demo.Repository;


import com.example.demo.Entity.LeadDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadDetailsRepository extends JpaRepository<LeadDetail, Long>
{


}
