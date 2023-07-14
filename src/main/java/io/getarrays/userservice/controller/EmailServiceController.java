package io.getarrays.userservice.controller;

import io.getarrays.userservice.controller.dto.SendMailRequestBody;
import io.getarrays.userservice.controller.dto.SendMailResponseBody;
import io.getarrays.userservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/email")
public class EmailServiceController {
    private final EmailService emailService;

    public EmailServiceController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(path = "/send")
    public ResponseEntity<SendMailResponseBody> mobileRecharge(
            @RequestBody SendMailRequestBody requestBody
    ) {
        try {
            log.info("Request received: {}", requestBody);
            SendMailResponseBody responseBody = emailService.sendSimpleMailMessage(requestBody.getName(), requestBody.getToEmail());
            log.info("Response : {}", responseBody);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseBody);
        } catch (Exception ex) {
            log.error("Exception:: : {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}


