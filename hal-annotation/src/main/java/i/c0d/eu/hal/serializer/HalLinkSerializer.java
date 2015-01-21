package i.c0d.eu.hal.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import i.c0d.eu.hal.LinkElement;

import java.io.IOException;

public class HalLinkSerializer extends JsonSerializer<LinkElement> {
    @Override
    public void serialize(LinkElement linkElement, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName(linkElement.getName());
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("href", linkElement.getHref());

        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }
}
