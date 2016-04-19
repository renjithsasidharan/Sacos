
package com.sacos.sacosandorid.models.skyscanner.browsedates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Dates {

    private List<OutboundDate> OutboundDates = new ArrayList<OutboundDate>();
    private List<InboundDate> InboundDates = new ArrayList<InboundDate>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The OutboundDates
     */
    public List<OutboundDate> getOutboundDates() {
        return OutboundDates;
    }

    /**
     * 
     * @param OutboundDates
     *     The OutboundDates
     */
    public void setOutboundDates(List<OutboundDate> OutboundDates) {
        this.OutboundDates = OutboundDates;
    }

    /**
     * 
     * @return
     *     The InboundDates
     */
    public List<InboundDate> getInboundDates() {
        return InboundDates;
    }

    /**
     * 
     * @param InboundDates
     *     The InboundDates
     */
    public void setInboundDates(List<InboundDate> InboundDates) {
        this.InboundDates = InboundDates;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
