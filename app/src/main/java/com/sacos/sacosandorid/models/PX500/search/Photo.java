
package com.sacos.sacosandorid.models.PX500.search;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Photo {

    private String image_url;
    private User user;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The imageUrl
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     * 
     * @param imageUrl
     *     The image_url
     */
    public void setImage_url(String imageUrl) {
        this.image_url = imageUrl;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
