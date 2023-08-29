package service;

import lombok.RequiredArgsConstructor;
import model.MessageDto;
import model.mapper.MessageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageService {
    private final MessageMapper mapper;
    private final MessageRepository repository;

    public List<MessageDto> getAllMessages() {
        return mapper.entityListtoDtoList(repository.findAll());
    }

    @Transactional
    public MessageDto save(MessageDto dto) {
        return mapper.entitytoDto(repository.save(mapper.dtotoEntity(dto)));
    }
}
