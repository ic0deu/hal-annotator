package i.c0d.eu.hal.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import i.c0d.eu.hal.LinkElement;
import i.c0d.eu.hal.annotation.HalLink;

import java.util.Set;

/**
 * Created by amasucci on 22/01/2015.
 */
public class Order {
    @JsonProperty
    private float total;
    @JsonProperty
    private String status;
    @JsonProperty
    private String currency;
    @HalLink
    private Set<LinkElement> links;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Set<LinkElement> getLinks() {
        return links;
    }

    public void setLinks(Set<LinkElement> links) {
        this.links = links;
    }
}
