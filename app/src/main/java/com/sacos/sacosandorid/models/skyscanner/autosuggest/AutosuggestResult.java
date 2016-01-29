
package com.sacos.sacosandorid.models.skyscanner.autosuggest;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AutosuggestResult {

    private List<Place> Places = new ArrayList<Place>();

    /**
     * 
     * @return
     *     The Places
     */
    public List<Place> getPlaces() {
        return Places;
    }

    /**
     * 
     * @param Places
     *     The Places
     */
    public void setPlaces(List<Place> Places) {
        this.Places = Places;
    }

}
