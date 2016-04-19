
package com.sacos.sacosandorid.models.skyscanner.browsedates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class InboundLeg {

    private List<Integer> CarrierIds = new ArrayList<Integer>();
    private int OriginId;
    private int DestinationId;
    private String DepartureDate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The CarrierIds
     */
    public List<Integer> getCarrierIds() {
        return CarrierIds;
    }

    /**
     * 
     * @param CarrierIds
     *     The CarrierIds
     */
    public void setCarrierIds(List<Integer> CarrierIds) {
        this.CarrierIds = CarrierIds;
    }

    /**
     * 
     * @return
     *     The OriginId
     */
    public int getOriginId() {
        return OriginId;
    }

    /**
     * 
     * @param OriginId
     *     The OriginId
     */
    public void setOriginId(int OriginId) {
        this.OriginId = OriginId;
    }

    /**
     * 
     * @return
     *     The DestinationId
     */
    public int getDestinationId() {
        return DestinationId;
    }

    /**
     * 
     * @param DestinationId
     *     The DestinationId
     */
    public void setDestinationId(int DestinationId) {
        this.DestinationId = DestinationId;
    }

    /**
     * 
     * @return
     *     The DepartureDate
     */
    public String getDepartureDate() {
        return DepartureDate;
    }

    /**
     * 
     * @param DepartureDate
     *     The DepartureDate
     */
    public void setDepartureDate(String DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
