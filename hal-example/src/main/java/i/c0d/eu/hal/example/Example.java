package i.c0d.eu.hal.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import i.c0d.eu.hal.EmbeddedElement;
import i.c0d.eu.hal.LinkElement;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amasucci on 21/01/2015.
 */
public class Example {
    public static void main(String[] args) throws JsonProcessingException {
        RestResponse restResponse = new RestResponse();
        LinkElement self =          new LinkElement.Builder("self", "/orders").build();
        
        LinkElement ea =            new LinkElement.Builder("http://eample.com/docs/rels/{rel}").name("ea").templated(true).build();
        LinkElement curies =        new LinkElement.ArrayBuilder("curies").withLink(ea).build();
        
        LinkElement next =          new LinkElement.Builder("next", "/orders?page=2").build();
        
        LinkElement eafind =        new LinkElement.Builder("ea:find", "/orders{?id}").templated(true).build();
        
        LinkElement fred =          new LinkElement.Builder("/admins/2").title("Fred").build();
        LinkElement kate =          new LinkElement.Builder("/admins/5").title("Kate").build();
        LinkElement eaadmin =       new LinkElement.ArrayBuilder("ea:admin").withLink(fred).withLink(kate).build();

        Set<LinkElement> elements = new HashSet<LinkElement>();
        elements.add(self);
        elements.add(curies);
        elements.add(next);
        elements.add(eafind);
        elements.add(eaadmin);


        
        LinkElement selfOrder1 = new LinkElement.Builder("self", "/orders/123").build();
        LinkElement basket1 = new LinkElement.Builder("ea:basket", "/baskets/98712").build();
        LinkElement customer1 = new LinkElement.Builder("ea:customer", "/customers/7809").build();
        Set<LinkElement> order1Elements = new HashSet<LinkElement>();
        order1Elements.add(selfOrder1);
        order1Elements.add(basket1);
        order1Elements.add(customer1);
        
        LinkElement selfOrder2 = new LinkElement.Builder("self", "/orders/124").build();
        LinkElement basket2 = new LinkElement.Builder("ea:basket", "/baskets/97213").build();
        LinkElement customer2 = new LinkElement.Builder("ea:customer", "/customers/12369").build();
        Set<LinkElement> order2Elements = new HashSet<LinkElement>();
        order2Elements.add(selfOrder2);
        order2Elements.add(basket2);
        order2Elements.add(customer2);
        
        Order order1 = new Order();
        order1.setCurrency("USD");
        order1.setStatus("shipped");
        order1.setTotal(30.00f);
        order1.setLinks(order1Elements);
        
        Order order2 = new Order();
        order2.setCurrency("USD");
        order2.setStatus("processing");
        order2.setTotal(20.00f);
        order2.setLinks(order2Elements);
        
        Set<Order> orders = new HashSet<Order>();
        orders.add(order1);
        orders.add(order2);
        EmbeddedElement<Set<Order>> embeddedOrders = new EmbeddedElement<Set<Order>>("ea:order", orders);
        
        
        restResponse.setLinkElements(elements);
        restResponse.setEmbeddedElement(embeddedOrders);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(restResponse);
        System.out.println(json);
    }
}
