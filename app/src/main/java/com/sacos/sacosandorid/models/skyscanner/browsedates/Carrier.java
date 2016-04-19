
package com.sacos.sacosandorid.models.skyscanner.browsedates;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Carrier {

    private int CarrierId;
    private String Name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The CarrierId
     */
    public int getCarrierId() {
        return CarrierId;
    }

    /**
     * 
     * @param CarrierId
     *     The CarrierId
     */
    public void setCarrierId(int CarrierId) {
        this.CarrierId = CarrierId;
    }

    /**
     * 
     * @return
     *     The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
