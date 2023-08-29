package model.mapper;

import entity.Message;
import model.MessageDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    MessageDto entitytoDto(Message Message);

    List<MessageDto> entityListtoDtoList(List<Message> messages);

    Message dtotoEntity(MessageDto messageDto);
}
