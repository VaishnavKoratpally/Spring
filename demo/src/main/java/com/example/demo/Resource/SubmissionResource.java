package com.example.demo.Resource;


import com.example.demo.dto.SubmissionDTO;
import com.example.demo.Service.ISubmissionService;
//import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submission")
public class SubmissionResource {

    @Autowired
    private ISubmissionService service;

    @PostMapping
    public ResponseEntity<SubmissionDTO> createSubmission(@RequestBody SubmissionDTO submissionDTO){
//

        SubmissionDTO responseDTO = service.createSubmission(submissionDTO);
        return  new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public SubmissionDTO getSubmission(@PathVariable("id") String id){
        return service.getSubmissionById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubmission(@PathParam("id") String id){
        // call service
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}