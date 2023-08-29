package controller;

import lombok.RequiredArgsConstructor;
import model.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.MessageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
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
