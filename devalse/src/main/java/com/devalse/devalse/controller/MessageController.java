package com.devalse.devalse.controller;

import lombok.RequiredArgsConstructor;
import com.devalse.devalse.model.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devalse.devalse.service.MessageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {
    private final MessageService service;

    @GetMapping
    ResponseEntity<List<MessageDto>> getAllMessages() {
        return new ResponseEntity(service.getAllMessages(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<MessageDto> saveMessage(@RequestBody MessageDto dto) {
        return new ResponseEntity(service.save(dto), HttpStatus.CREATED);
    }
}
