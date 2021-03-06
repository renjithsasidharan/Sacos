package com.sacos.sacosandorid.models;


import org.joda.time.DateTime;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

/**
 * Created by renjith on 14/03/16.
 */

@Generated("org.jsonschema2pojo")
public class ExploreModel {

  private int quoteId;
  private int price;
  private String priceString;
  private int DestinationId;
  private String destination;
  private DateTime onwardDate;
  private DateTime returnDate;
  private String originIataCode;
  private String destinationIataCode;
  private String days;
  private String OutboundPictureUrl;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   *
   * @return
   * The quote id
   */
  public int getQuoteId() {
    return quoteId;
  }

  /**
   *
   * @param price
   * The quote id
   */
  public void setQuoteId(int quoteId) {
    this.quoteId = quoteId;
  }

  /**
   *
   * @return
   * The price
   */
  public int getPrice() {
    return price;
  }

  /**
   *
   * @param price
   * The price
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   *
   * @return
   * The price string
   */
  public String getPriceString() {
    return priceString;
  }

  /**
   *
   * @param price
   * The price string
   */
  public void setPriceString(String price) {
    this.priceString = price;
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
   *     The Origin Iata Code
   */
  public String getOriginIataCode() {
    return originIataCode;
  }

  /**
   *
   * @param originIataCode
   *     The Origin Iata Code
   */
  public void setOriginIataCode(String originIataCode) {
    this.originIataCode = originIataCode;
  }

  /**
   *
   * @return
   *     The Destination Iata Code
   */
  public String getDestinationIataCode() {
    return destinationIataCode;
  }

  /**
   *
   * @param destinationIataCode
   *     The Destination Iata Code
   */
  public void setDestinationIataCode(String destinationIataCode) {
    this.destinationIataCode = destinationIataCode;
  }


  /**
   *
   * @return
   * The destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   *
   * @param destination
   * The destination
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   *
   * @return
   * The days
   */
  public String getDays() {
    return days;
  }

  /**
   *
   * @param days
   * The days
   */
  public void setDays(String days) {
    this.days = days;
  }


  /**
   *
   * @return
   * The Onward Date
   */
  public DateTime getOnwardDate() {
    return onwardDate;
  }


  /**
   *
   * @param Onward Date
   * The Onward Date
   */
  public void setOnwardDate(DateTime date) {
    this.onwardDate = date;
  }


  /**
   *
   * @param Return Date
   * The Return Date
   */
  public void setReturnDate(DateTime date) {
    this.returnDate = date;
  }


  /**
   *
   * @return
   * The Return Date
   */
  public DateTime getReturnDate() {
    return returnDate;
  }

  /**
   *
   * @return
   *     The OutboundPictureUrl
   */
  public String getOutboundPictureUrl() {
    return OutboundPictureUrl;
  }

  /**
   *
   * @param OutboundPictureUrl
   *     The OutboundPictureUrl
   */
  public void setOutboundPictureUrl(String OutboundPictureUrl) {
    this.OutboundPictureUrl = OutboundPictureUrl;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
