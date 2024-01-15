package org.acme;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class ChatInputMessage {
    private UUID fromUserId;
    private String text;
}

