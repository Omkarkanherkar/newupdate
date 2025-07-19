package com.substring.chat.controllers;

import java.time.LocalDateTime;

import com.substring.chat.config.AppConfig;
import com.substring.chat.entities.Message;
import com.substring.chat.entities.Room;
import com.substring.chat.payload.MessageRequest;
import com.substring.chat.repositories.RoomRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

@RestController
@CrossOrigin(origins = "${app.frontend-base-url}")

public class ChatController {

    private final RoomRepository roomRepository;
    private final AppConfig appConfig;

    public ChatController(RoomRepository roomRepository, AppConfig appConfig) {
        this.roomRepository = roomRepository;
        this.appConfig = appConfig;
    }

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            MessageRequest request // ❌ Removed @RequestBody here
    ) {
        Room room = roomRepository.findByRoomId(request.getRoomId());

        if (room == null) {
            throw new RuntimeException("Room not found");
        }

        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());

        room.getMessages().add(message);
        roomRepository.save(room);

        return message;
    }
}
