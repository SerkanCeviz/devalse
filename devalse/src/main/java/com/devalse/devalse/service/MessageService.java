package com.devalse.devalse.service;

import com.devalse.devalse.model.MessageDto;
import com.devalse.devalse.model.mapper.MessageMapper;
import com.devalse.devalse.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageService {
    private final MessageRepository repository;

    public List<MessageDto> getAllMessages() {
        return MessageMapper.INSTANCE.entityListtoDtoList(repository.findAll());
    }

    @Transactional
    public MessageDto save(MessageDto dto) {
        return MessageMapper.INSTANCE.entitytoDto(repository.save(MessageMapper.INSTANCE.dtotoEntity(dto)));
    }
}
