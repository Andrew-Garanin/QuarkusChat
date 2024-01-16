package org.acme;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import lombok.SneakyThrows;

import java.util.Objects;

public class ChatMessageDecoder implements Decoder.Text<ChatInputMessage> {

    private final ObjectMapper jackson = ChatMessageDecoder.getJackson();

    @Override
    @SneakyThrows
    public ChatInputMessage decode(String s) throws DecodeException {
        try{
            return jackson.readValue(s, ChatInputMessage.class);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean willDecode(String s) {
        return !Objects.equals(s, "");
    }

    public static ObjectMapper getJackson() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        om.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        //om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        om.registerModule(new JavaTimeModule());
        return om;
    }

}
