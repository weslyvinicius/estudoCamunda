package io.flowing.retail.kafka.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class OrderFlowContext {

  private String traceId;
  private String orderId;
  private String pickId;
  private String shipmentId;

  public static OrderFlowContext fromJson(String json) {
    try {
      return new ObjectMapper().readValue(json, OrderFlowContext.class);
    } catch (Exception e) {
      throw new RuntimeException("Could not deserialize context from JSON: " + e.getMessage(), e);
    }
  }
  
  public String asJson() {
    try {
      return new ObjectMapper().writeValueAsString(this);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Could not serialize context to JSON: " + e.getMessage(), e);
    }
  }
  
  public String getPickId() {
    return pickId;
  }
  public OrderFlowContext setPickId(String pickId) {
    this.pickId = pickId;
    return this;
  }
  public String getTraceId() {
    return traceId;
  }
  public OrderFlowContext setTraceId(String traceId) {
    this.traceId = traceId;
    return this;
  }
  public String getOrderId() {
    return orderId;
  }
  public OrderFlowContext setOrderId(String orderId) {
    this.orderId = orderId;
    return this;
  }
  public String getShipmentId() {
    return shipmentId;
  }
  public OrderFlowContext setShipmentId(String shipmentId) {
    this.shipmentId = shipmentId;
    return this;
  }
  
}
