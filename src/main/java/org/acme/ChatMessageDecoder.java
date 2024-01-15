package org.acme;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import lombok.SneakyThrows;

public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {

    private final ObjectMapper jackson = ChatMessageDecoder.getJackson();

    @Override
    @SneakyThrows
    public ChatMessage decode(String s) throws DecodeException {
        return jackson.readValue(s, ChatMessage.class);
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

    public static ObjectMapper getJackson() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        om.registerModule(new JavaTimeModule());
        return om;
    }

}
