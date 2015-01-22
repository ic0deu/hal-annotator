package i.c0d.eu.hal.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import i.c0d.eu.hal.EmbeddedElement;
import i.c0d.eu.hal.LinkElement;
import i.c0d.eu.hal.annotation.HalEmbedded;
import i.c0d.eu.hal.annotation.HalLink;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse {

    public Set<LinkElement> getLinkElements() {
        return linkElements;
    }

    public void setLinkElements(Set<LinkElement> linkElements) {
        this.linkElements = linkElements;
    }

    public EmbeddedElement<Set<Order>> getEmbeddedElement() {
        return embeddedElement;
    }

    public void setEmbeddedElement(EmbeddedElement<Set<Order>> embeddedElement) {
        this.embeddedElement = embeddedElement;
    }

    public int getCurrentlyProcessing() {
        return currentlyProcessing;
    }

    public void setCurrentlyProcessing(int currentlyProcessing) {
        this.currentlyProcessing = currentlyProcessing;
    }

    public int getShippedToday() {
        return shippedToday;
    }

    public void setShippedToday(int shippedToday) {
        this.shippedToday = shippedToday;
    }

    @HalLink
    private Set<LinkElement> linkElements;

    @HalEmbedded
    private EmbeddedElement<Set<Order>> embeddedElement;
    
    private int currentlyProcessing;
    
    private int shippedToday;
}
