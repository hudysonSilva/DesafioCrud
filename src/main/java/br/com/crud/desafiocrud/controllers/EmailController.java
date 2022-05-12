package br.com.crud.desafiocrud.controllers;



import br.com.crud.desafiocrud.dto.EmailDto;
import br.com.crud.desafiocrud.entity.Email;
import br.com.crud.desafiocrud.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        Email emailModel = new Email();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

//    @GetMapping("/emails")
//    public ResponseEntity<Page<EmailModel>> getAllEmails(@PageableDefault(page = 0, size = 5, sort = "emailId", direction = Sort.Direction.DESC) Pageable pageable){
//        return new ResponseEntity<>(emailService.findAll(pageable), HttpStatus.OK);
//    }
//
//    @GetMapping("/emails/{emailId}")
//    public ResponseEntity<Object> getOneEmail(@PathVariable(value="emailId") UUID emailId){
//        Optional<EmailModel> emailModelOptional = emailService.findById(emailId);
//        if(!emailModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
//        }else {
//            return ResponseEntity.status(HttpStatus.OK).body(emailModelOptional.get());
//        }
//    }
}
