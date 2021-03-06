package i.c0d.eu.hal.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import i.c0d.eu.hal.LinkElement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class HalLinkSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object linkElements, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(linkElements instanceof LinkElement) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName(((LinkElement) linkElements).getName());
            generateLinkElement(jsonGenerator, (LinkElement) linkElements);
            jsonGenerator.writeEndObject();
        }
        
        if(linkElements instanceof Set) {
            Iterator<LinkElement> linkElementIterator = ((Set<LinkElement>) linkElements).iterator();
            jsonGenerator.writeStartObject();

            while (linkElementIterator.hasNext()) {
                LinkElement element = linkElementIterator.next();
                jsonGenerator.writeFieldName(element.getLinkName());
                if(element.getHref() != null) {
                    generateLinkElement(jsonGenerator, element);
                } else {
                    jsonGenerator.writeStartArray();
                    for(LinkElement subElement : element.getSubElements()) {
                        generateLinkElement(jsonGenerator, subElement);
                    }
                    jsonGenerator.writeEndArray();
                    
                }
            }
            jsonGenerator.writeEndObject();
        }
    }
    
    private void generateLinkElement (JsonGenerator jsonGenerator, LinkElement element) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("href", element.getHref());
        if (element.getHreflang() != null)
            jsonGenerator.writeStringField("hreflang", element.getHreflang());
        if (element.getDeprecation() != null)
            jsonGenerator.writeStringField("deprecation", element.getDeprecation());
        if (element.getProfile() != null)
            jsonGenerator.writeStringField("profile", element.getProfile());
        if (element.getTitle() != null)
            jsonGenerator.writeStringField("title", element.getTitle());
        if (element.getType() != null)
            jsonGenerator.writeStringField("type", element.getType());
        if (element.getTemplated() != null)
            jsonGenerator.writeBooleanField("templated", element.getTemplated());
        jsonGenerator.writeEndObject();
        
    }
}
