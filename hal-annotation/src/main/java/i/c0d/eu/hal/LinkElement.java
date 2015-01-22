package i.c0d.eu.hal;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkElement {
    /**5.1.  href
     *
     *  The "href" property is REQUIRED.
     *
     *  Its value is either a URI [RFC3986] or a URI Template [RFC6570].
     *
     *  If the value is a URI Template then the Link Object SHOULD have a
     *  "templated" attribute whose value is true.
     */
    @JsonProperty
    private String href;

    /** 5.2.  templated
     *
     *  The "templated" property is OPTIONAL.
     *
     *  Its value is boolean and SHOULD be true when the Link Object's "href"
     *  property is a URI Template.
     *
     *  Its value SHOULD be considered false if it is undefined or any other
     *  value than true.
     */
    @JsonProperty
    private Boolean templated;

    /** 5.3.  type
     *
     *  The "type" property is OPTIONAL.
     *
     *  Its value is a string used as a hint to indicate the media type
     *  expected when dereferencing the target resource.
     */
    @JsonProperty
    private String type;

    /** 5.4.  deprecation
     *
     *  The "deprecation" property is OPTIONAL.
     *
     *  Its presence indicates that the link is to be deprecated (i.e.
     *  removed) at a future date.  Its value is a URL that SHOULD provide
     *  further information about the deprecation.
     *
     *  A client SHOULD provide some notification (for example, by logging a
     *  warning message) whenever it traverses over a link that has this
     *  property.  The notification SHOULD include the deprecation property's
     *  value so that a client manitainer can easily find information about
     *  the deprecation.
     */
    @JsonProperty
    private String deprecation;

    /** 5.5.  name
     *
     * The "name" property is OPTIONAL.
     *
     * Its value MAY be used as a secondary key for selecting Link Objects
     * which share the same relation type.
     */
    @JsonProperty
    private String name;

    /** 5.6.  profile
     *
     * The "profile" property is OPTIONAL.
     *
     * Its value is a string which is a URI that hints about the profile (as
     * defined by [I-D.wilde-profile-link]) of the target resource.
     */
    @JsonProperty
    private String profile;

    /** 5.7.  title
     *
     * The "title" property is OPTIONAL.
     *
     * Its value is a string and is intended for labelling the link with a
     * human-readable identifier (as defined by [RFC5988]).
     */
    @JsonProperty
    private String title;

    /** 5.8.  hreflang
     *
     * The "hreflang" property is OPTIONAL.
     *
     * Its value is a string and is intended for indicating the language of
     * the target resource (as defined by [RFC5988]).
     *
     */
    @JsonProperty
    private String hreflang;
    
    @JsonIgnore
    private String linkName;

    @JsonIgnore
    public Set<LinkElement> getSubElements() {
        return subElements;
    }

    @JsonIgnore
    private Set<LinkElement> subElements;

    public String getHref() {
        return href;
    }

    public Boolean getTemplated() {
        return templated;
    }

    public String getType() {
        return type;
    }

    public String getDeprecation() {
        return deprecation;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    public String getTitle() {
        return title;
    }

    public String getHreflang() {
        return hreflang;
    }

    @JsonIgnore
    public String getLinkName() { return linkName; }

    public static class ArrayBuilder {
        private final String linkName;
        private Set<LinkElement> linkElements = new HashSet<LinkElement>();
        
        public ArrayBuilder withLink(LinkElement linkElement) { this.linkElements.add(linkElement); return this;}

        public ArrayBuilder(String linkName) {
            this.linkName = linkName;
        }
        
        public LinkElement build() {
            LinkElement subElements = new LinkElement();
            subElements.linkName = linkName;
            subElements.subElements = linkElements;
            return subElements;
        }
        
    }
    
    public static class Builder {
        // Required parameters
        private final String href;
        // Optional parameters - initialized to default values
        private String linkName;
        private Boolean templated;
        private String type;
        private String deprecation;
        private String name;
        private String profile;
        private String title;
        private String hreflang;

        public Builder(String linkName, String href)
        {  this.href = href; this.linkName = linkName; }
        public Builder(String href)
        {  this.href = href; }
        
        public Builder templated(Boolean templated)
        {  this.templated = templated;      return this; }
        public Builder type(String type)
        {  this.type = type;      return this; }
        public Builder deprecation(String deprecation)
        {  this.deprecation = deprecation;      return this; }
        public Builder name(String name)
        {  this.name = name;      return this; }
        public Builder profile(String profile)
        {  this.profile = profile;      return this; }
        public Builder title(String title)
        {  this.title = title;      return this; }
        public Builder hreflang(String hreflang)
        {  this.hreflang = hreflang;      return this; }
        public LinkElement build() {
            return new LinkElement(this);
        }
        
    }

    private LinkElement() {}
    
    private LinkElement(Builder builder) {
        this.href        = builder.href;
        this.templated   = builder.templated;
        this.type        = builder.type;
        this.deprecation = builder.deprecation;
        this.name        = builder.name;
        this.profile     = builder.profile;
        this.title       = builder.title;
        this.hreflang    = builder.hreflang;
        this.linkName    = builder.linkName;
    }
    
    
}
