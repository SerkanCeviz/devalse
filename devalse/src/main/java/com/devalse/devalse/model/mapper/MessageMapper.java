package com.devalse.devalse.model.mapper;

import com.devalse.devalse.entity.Message;
import com.devalse.devalse.model.MessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);
    MessageDto entitytoDto(Message Message);

    List<MessageDto> entityListtoDtoList(List<Message> messages);

    Message dtotoEntity(MessageDto messageDto);
}
