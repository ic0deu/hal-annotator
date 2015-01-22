package i.c0d.eu.hal;

/**
 * Created by amasucci on 22/01/2015.
 */
public class EmbeddedElement<T> {
    
    private String name;
    private T embedded;
    
    public String getName() {
        return name;
    }

    public Object getEmbedded() {
        return embedded;
    }
    
    public EmbeddedElement(String name, T embedded) {
        this.name = name;
        this.embedded = embedded;
    }

    
}
