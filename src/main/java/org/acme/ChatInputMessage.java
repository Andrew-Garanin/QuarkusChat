package org.acme;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
//@ToString
public class ChatInputMessage {

    private String fromUserId;
    private String text;

    @Override
    public String toString() {
        return "ChatInputMessage(fromUserId=" + this.fromUserId + ", text=" + this.text + ")";
    }
}

