package com.middleware.demo.service;

import com.middleware.demo.dto.ECitationPayloadDto;
import com.middleware.demo.model.ECitation;
import com.middleware.demo.repository.ECitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class ECitationService {

   @Autowired
   private ECitationRepository eCitationRepository;


   public ResponseEntity<Object> getCitations() {
      List<ECitation> eCitations = eCitationRepository.findAll();
      return new ResponseEntity<>(eCitations, HttpStatus.OK);
   }

   public ResponseEntity<Object> saveECitation(@RequestBody ECitationPayloadDto payload) {
      ECitation eCitation = new ECitation();
      eCitation.setCourt(payload.getInformation().getCourt());
      eCitation.setOfficer(payload.getInformation().getOfficer());
      eCitation.setViolation(payload.getInformation().getViolation());
      ECitation newECitation = eCitationRepository.save(eCitation);
      System.out.println("qwewqewqe");
      return new ResponseEntity<>(newECitation, HttpStatus.OK);
   }

   public ResponseEntity<Object> updateECitation(@RequestBody ECitationPayloadDto payload) {
      Optional<ECitation> result = eCitationRepository.findByCourtAndOfficerAndViolation(payload.getInformation().getCourt(), payload.getInformation().getOfficer(), payload.getInformation().getViolation());
      if(result.isPresent()) {
         ECitation eCitation = result.get();
         eCitation.setViolation(payload.getInformation().getViolation());
         eCitation.setOfficer(payload.getInformation().getOfficer());
         eCitation.setCourt(payload.getInformation().getCourt());
         ECitation newECitation = eCitationRepository.save(eCitation);
         return new ResponseEntity<>(newECitation, HttpStatus.OK);
      }

      return new ResponseEntity<>("E-Citation Not Found", HttpStatus.NOT_FOUND);
   }

}