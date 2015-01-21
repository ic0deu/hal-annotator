package i.c0d.eu.hal.example;

import i.c0d.eu.hal.LinkElement;
import i.c0d.eu.hal.annotation.HalEmbedded;
import i.c0d.eu.hal.annotation.HalLink;

public class RestResponse {

    @HalLink
    private LinkElement name;

    @HalEmbedded
    private RestResponse restResponse;


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String surname;


    public LinkElement getName() {
        return name;
    }

    public void setName(LinkElement name) {
        this.name = name;
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
