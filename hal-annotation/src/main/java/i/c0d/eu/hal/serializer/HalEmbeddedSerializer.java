package i.c0d.eu.hal.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class HalEmbeddedSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object embedded, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(embedded);
    }
}
