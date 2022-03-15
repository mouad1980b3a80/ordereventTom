package com.example.web;

import java.io.Serializable;
import java.util.Objects;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;

public class LsValMAPForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @FormParam("startRow")
    private Long startRow;

   // @NotBlank
    @FormParam("endRow")
    @MvcBinding
    private String endRow;

    //@NotBlank
    //@Size(min = 10, max = 2000)
    @FormParam("orderType")
    @MvcBinding
    private String orderType;

    public Long getStartRow() {
        return startRow;
    }

    public void setStartRow(Long startRow) {
        this.startRow = startRow;
    }

    public String getEndRow() {
        return endRow;
    }

    public void setEndRow(String endRow) {
        this.endRow = endRow;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
