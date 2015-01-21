package i.c0d.eu.hal.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import i.c0d.eu.hal.LinkElement;

/**
 * Created by amasucci on 21/01/2015.
 */
public class Example {
    public static void main(String[] args) throws JsonProcessingException {
        RestResponse restResponse = new RestResponse();
        RestResponse restResponse2 = new RestResponse();

        LinkElement el1 = new LinkElement.Builder("http://somethingsomething.com").name("self").build();
        LinkElement el2 = new LinkElement.Builder("http://somethingsomething2.com").name("posdpa:pdosap:dk").build();

        restResponse2.setName(el1);
        restResponse2.setRestResponse(restResponse);

        restResponse.setName(el2);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(restResponse2);
        System.out.println(json);
    }
}
