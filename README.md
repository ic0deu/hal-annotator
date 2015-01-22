# hal-annotator
Library to serialize objects in HAL format (http://stateless.co/hal_specification.html)

# Usage
hal annotator provides two annotations ```@HalLink``` and ```@HalEmbedded```,
```@HalLink``` must be used only to annotate fields of the following types:
* ```LinkElement```
* ```Set<LinkElement>```

```@HalEmbedded``` can be used to annotate any Object.

Example:
```java 
package i.c0d.eu.hal.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import i.c0d.eu.hal.EmbeddedElement;
import i.c0d.eu.hal.LinkElement;
import i.c0d.eu.hal.annotation.HalEmbedded;
import i.c0d.eu.hal.annotation.HalLink;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse {

    @HalLink
    private Set<LinkElement> linkElements;

    @HalEmbedded
    private EmbeddedElement<Set<Order>> embeddedElement;
    
    private int currentlyProcessing;
    
    private int shippedToday;
    
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

}
```

Will generate the following JSON:
```JSON
{
  "currentlyProcessing" : 0,
  "shippedToday" : 0,
  "_links" : {
    "ea:admin" : [ {
      "href" : "/admins/5",
      "title" : "Kate"
    }, {
      "href" : "/admins/2",
      "title" : "Fred"
    } ],
    "self" : {
      "href" : "/orders"
    },
    "ea:find" : {
      "href" : "/orders{?id}",
      "templated" : true
    },
    "curies" : [ {
      "href" : "http://eample.com/docs/rels/{rel}",
      "templated" : true
    } ],
    "next" : {
      "href" : "/orders?page=2"
    }
  },
  "_embedded" : {
    "ea:order" : [ {
      "total" : 20.0,
      "status" : "processing",
      "currency" : "USD",
      "_links" : {
        "ea:customer" : {
          "href" : "/customers/12369"
        },
        "self" : {
          "href" : "/orders/124"
        },
        "ea:basket" : {
          "href" : "/baskets/97213"
        }
      }
    }, {
      "total" : 30.0,
      "status" : "shipped",
      "currency" : "USD",
      "_links" : {
        "ea:customer" : {
          "href" : "/customers/7809"
        },
        "self" : {
          "href" : "/orders/123"
        },
        "ea:basket" : {
          "href" : "/baskets/98712"
        }
      }
    } ]
  }
}
```
