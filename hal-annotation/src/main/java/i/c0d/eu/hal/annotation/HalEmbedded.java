package i.c0d.eu.hal.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import i.c0d.eu.hal.serializer.HalEmbeddedSerializer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using= HalEmbeddedSerializer.class)
@JsonProperty("_embedded")
public @interface HalEmbedded {
}
