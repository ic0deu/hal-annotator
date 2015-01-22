package i.c0d.eu.hal.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import i.c0d.eu.hal.EmbeddedElement;

import java.io.IOException;

public class HalEmbeddedSerializer extends JsonSerializer<EmbeddedElement> {
    @Override
    public void serialize(EmbeddedElement embedded, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName((embedded).getName());
        jsonGenerator.writeObject(embedded.getEmbedded());
        jsonGenerator.writeEndObject();
    }
    
}
