package com.middleware.demo.controller;

import com.middleware.demo.dto.ECitationPayloadDto;
import com.middleware.demo.service.ECitationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/td-receiver/e-citations")
public class ECitationController {

   private final Logger logger = LoggerFactory.getLogger(getClass());

   @Autowired private ECitationService eCitationService;

   @GetMapping
   @ResponseBody
   public ResponseEntity<Object> getECitations() {
      return eCitationService.getCitations();
   }

   @PostMapping
   @ResponseBody
   public ResponseEntity<Object> addECitation(@RequestBody ECitationPayloadDto payload) {
      logger.info("Create citation started...");
      return eCitationService.saveECitation(payload);
   }

   @PutMapping
   @ResponseBody
   public ResponseEntity<Object> updateECitation(@RequestBody ECitationPayloadDto payload) {
      logger.info("Update citation started...");
      return eCitationService.saveECitation(payload);
   }
}
