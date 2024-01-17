package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import lombok.SneakyThrows;

public class ChatMessageEncoder implements Encoder.Text<ChatInputMessage> {

    private final ObjectMapper jackson = ChatMessageDecoder.getJackson();

    @Override
    @SneakyThrows
    public String encode(ChatInputMessage chatInputMessage) throws EncodeException {
        try{
            return jackson.writeValueAsString(chatInputMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

}