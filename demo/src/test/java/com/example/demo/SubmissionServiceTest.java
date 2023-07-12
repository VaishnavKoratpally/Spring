package com.example.demo;

import com.example.demo.SubmissionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubmissionServiceTest {

    @Mock
    private SubmissionRepository submissionRepository;

    @InjectMocks
    private SubmissionService submissionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPostSubmission() {
        SubmissionForm sf = new SubmissionForm();
        sf.setName("John Doe");
        sf.setVendorName("ABC Corp");
        sf.setRate(100);
        sf.setLeadName("Jane Smith");
        sf.setTechnology("Java");

        Mockito.when(submissionRepository.postSubmission(sf)).thenReturn(sf);

        SubmissionForm result = submissionService.postSubmission(sf);

        Assertions.assertEquals(sf, result);
        Mockito.verify(submissionRepository, Mockito.times(1)).postSubmission(sf);
    }

    @Test
    public void testGetSubmissionFormById() {
        String id = "sampleId";
        SubmissionForm expectedForm = new SubmissionForm();
        expectedForm.setId(id);
        expectedForm.setName("John Doe");
        expectedForm.setVendorName("ABC Corp");
        expectedForm.setRate(100);
        expectedForm.setLeadName("Jane Smith");
        expectedForm.setTechnology("Java");

        Mockito.when(submissionRepository.getSubmissionFormById(id)).thenReturn(expectedForm);

        SubmissionForm result = submissionService.getSubmissionFormById(id);


        Assertions.assertEquals(expectedForm, result);
        Mockito.verify(submissionRepository, Mockito.times(1)).getSubmissionFormById(id);
    }

    @Test
    public void testGetAllSubmissions() {

        List<SubmissionForm> expectedForms = new ArrayList<>();
        SubmissionForm form1 = new SubmissionForm();
        form1.setName("John Doe");
        form1.setVendorName("ABC Corp");
        form1.setRate(100);
        form1.setLeadName("Jane Smith");
        form1.setTechnology("Java");

        SubmissionForm form2 = new SubmissionForm();
        form2.setName("Jane Doe");
        form2.setVendorName("XYZ Corp");
        form2.setRate(200);
        form2.setLeadName("John Smith");
        form2.setTechnology("Python");

        expectedForms.add(form1);
        expectedForms.add(form2);

        Mockito.when(submissionRepository.getallSubmissions()).thenReturn(expectedForms);


        List<SubmissionForm> result = submissionService.getallSubmissions();


        Assertions.assertEquals(expectedForms, result);
        Mockito.verify(submissionRepository, Mockito.times(1)).getallSubmissions();
    }

    @Test
    public void testEditSubmission() {
        SubmissionForm sf = new SubmissionForm();
        sf.setId("sampleId");
        sf.setName("John Doe");
        sf.setVendorName("ABC Corp");
        sf.setRate(200);
        sf.setLeadName("Jane Smith");
        sf.setTechnology("Java");

        Mockito.when(submissionRepository.editSubmission(sf)).thenReturn(sf);


        SubmissionForm result = submissionService.editSubmission(sf);


        Assertions.assertEquals(sf, result);
        Mockito.verify(submissionRepository, Mockito.times(1)).editSubmission(sf);
    }

    @Test
    public void testDeleteSubmission() {

        String id = "sampleId";
        List<SubmissionForm> expectedForms = new ArrayList<>();
        SubmissionForm form1 = new SubmissionForm();
        form1.setId("id1");
        form1.setName("John Doe");
        form1.setVendorName("ABC Corp");
        form1.setRate(100);
        form1.setLeadName("Jane Smith");
        form1.setTechnology("Java");

        SubmissionForm form2 = new SubmissionForm();
        form2.setId("id2");
        form2.setName("Jane Doe");
        form2.setVendorName("XYZ Corp");
        form2.setRate(200);
        form2.setLeadName("John Smith");
        form2.setTechnology("Python");

        expectedForms.add(form1);
        expectedForms.add(form2);

        Mockito.when(submissionRepository.deleteSubmission(id)).thenReturn(expectedForms);

        List<SubmissionForm> result = submissionService.deleteSubmission(id);

        Assertions.assertEquals(expectedForms, result);
        Mockito.verify(submissionRepository, Mockito.times(1)).deleteSubmission(id);
    }

}
