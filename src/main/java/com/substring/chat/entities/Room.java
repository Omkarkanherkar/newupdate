package com.substring.chat.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {
@Id
 private String id;
 private String roomId;
 private List<Message> messages=new ArrayList<>();
}
