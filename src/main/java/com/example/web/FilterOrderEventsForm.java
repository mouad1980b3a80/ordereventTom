package com.example.web;

import java.io.Serializable;
import java.util.Objects;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.mvc.RedirectScoped;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;

//TODO: rename to filter bean
@Named("filterOrderEventsForm")
//@RequestScoped
@RedirectScoped
public class FilterOrderEventsForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @FormParam("manId")
    @MvcBinding
    private String manId;

   // @NotBlank
    @FormParam("eventType")
    @MvcBinding
    private String eventType;

    //@NotBlank
    //@Size(min = 10, max = 2000)
    @FormParam("actionClass")
    @MvcBinding
    private String actionClass;

    @FormParam("orderId")
    @MvcBinding
    private String orderId;

    public String getManId() {
        return manId;
    }

    public void setManId(String manId) {
        this.manId = manId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getActionClass() {
        return actionClass;
    }

    public void setActionClass(String actionClass) {
        this.actionClass = actionClass;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
