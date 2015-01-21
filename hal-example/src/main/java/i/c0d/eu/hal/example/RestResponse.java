package i.c0d.eu.hal.example;

import i.c0d.eu.hal.LinkElement;
import i.c0d.eu.hal.annotation.HalEmbedded;
import i.c0d.eu.hal.annotation.HalLink;

import java.util.Set;

public class RestResponse {

    @HalLink
    private Set<LinkElement> name;

    @HalEmbedded
    private RestResponse restResponse;


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String surname;


    public Set<LinkElement> getName() {
        return name;
    }

    public void setName(Set<LinkElement> name) {
        this.name = name;
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
