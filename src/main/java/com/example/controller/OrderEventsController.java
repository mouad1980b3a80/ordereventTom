package com.example.controller;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.example.domain.OrderEventHistory;
import com.example.domain.Task;
import com.example.domain.TestLsValMAP;
import com.example.web.AlertMessage;
import com.example.web.LsValMAPForm;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.View;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.mvc.security.CsrfProtected;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Controller
@Path("events")
public class OrderEventsController implements Serializable {
    @Inject
    Models model;

    @Inject
    LsValMAPForm lsValMAPForm;

    @Inject
    private BindingResult validationResult;

    @GET

    @View("orderevents.xhtml")
    public void orderEventsVoid() { //TODO maybe discar
        System.out.println("lll");
        fetchOrderEvents();
        model.put("orderTypelocal", "TOrder");
        model.put("name", "Mouad");
        //lsValMAPForm.setEventType(form.getEventType());
        //form.getManId();
        //form.getActionClass();
       // lsValMAPForm.setManId("98726326");
      //  model.put("lsValMAPForm", lsValMAPForm);  // or we use the injected one?
       // model.put("maxTblRows", 5);
       // model.put("currentRows", 1);
    }

    private List<OrderEventHistory> fetchOrderEvents() {
        List<OrderEventHistory> orderEventHistories = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            OrderEventHistory orderEventHistory = new OrderEventHistory();
            orderEventHistory.setAufId(1l + i);
            orderEventHistory.setAufEdiId(1000l + i);
            orderEventHistory.setEventType("Order");
            orderEventHistory.setInfo1("info1_" + i);
            orderEventHistory.setEdiRef("ediRed_" + i);
            orderEventHistories.add(orderEventHistory);
        }
        model.put("orderEvents", orderEventHistories);
        return orderEventHistories;
    }

    @GET @Path("filter")
    public String helloString() {
       //TODO: pass current filter hidden fields if existing

        lsValMAPForm.setManId("MyMan");
        lsValMAPForm.setEventType("eventType");
        lsValMAPForm.setActionClass("ActionClass");
        model.put("name", "filterr");
        //model.put("lsValMAPForm", lsValMAPForm);
        return "ordereventsFilter.xhtml";
    }



    @POST
    //@CsrfProtected TODO reintegrate this! Idea use same page for filter and list and just switch visibility?

    //@ValidateOnExecution(type = ExecutableType.NONE)
    public Response save(
        @Valid @BeanParam LsValMAPForm form
        ) {
        //log.log(Level.INFO, "saving new lsValMAP @{0}", form);

        if (validationResult.isFailed()) {
            AlertMessage alert = AlertMessage.danger("Validation voilations!");
            validationResult.getAllErrors()
                .stream()
                .forEach((ParamError t) -> {
                    alert.addError(t.getParamName(), "", t.getMessage());
                });
            model.put("errors", alert);
            model.put("lsValMAP", form);
            return Response.status(BAD_REQUEST).entity("add.xhtml").build();
        }

        TestLsValMAP lsValMAP = new TestLsValMAP();
       // lsValMAP.setMapq(form.getValueOrig());
       // lsValMAP.setValueOrig(form.getMapq());

        //lsValMAPRepository.save(lsValMAP);

        // flashMessage.notify(Type.success, "lsValMAP was created successfully!");
        lsValMAPForm.setManId(form.getManId());
        lsValMAPForm.setActionClass(form.getActionClass());
        lsValMAPForm.setManId(form.getManId());
        //model.put("lsValMAPForm", lsValMAPForm);
        //model.put("lsValMAPForm", lsValMAPForm);

        return Response.ok("redirect:events").build();
    }

    @GET @Path("response")
    public Response helloResponse() {
        return Response.status(Response.Status.OK)
            .entity("hello.jsp")
            .build();
    }
}