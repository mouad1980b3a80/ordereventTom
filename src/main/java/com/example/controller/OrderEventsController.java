package com.example.controller;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import java.io.Serializable;
import com.example.domain.OrderEventRepository;
import com.example.web.AlertMessage;
import com.example.web.FilterOrderEventsForm;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Controller
@Path("events")
public class OrderEventsController implements Serializable {
    @Inject
    Models model;

    @Inject
    FilterOrderEventsForm lsValMAPForm;

    @Inject
    private BindingResult validationResult;

    @Inject
    OrderEventRepository orderEventRepository;

    @GET
    @View("orderevents.xhtml")
    public void orderEventsVoid() {
        System.out.println("lll");

        fetchOrderEvents();
        model.put("orderTypelocal", "TOrder");
        model.put("name", "Mouad");

    }

    private void fetchOrderEvents() {
        model.put("orderEvents",  orderEventRepository.getOrderEvents());
    }

    @GET @Path("filter")
    public String helloString() {

        lsValMAPForm.setManId("MyMan");
        lsValMAPForm.setEventType("eventType");
        lsValMAPForm.setActionClass("ActionClass");
        model.put("name", "filterr");
        return "ordereventsFilter.xhtml";
    }



    @POST
    //@CsrfProtected TODO reintegrate this! Idea use same page for filter and list and just switch visibility?

    //@ValidateOnExecution(type = ExecutableType.NONE)
    public Response save(
        @Valid @BeanParam FilterOrderEventsForm form
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

        // flashMessage.notify(Type.success, "lsValMAP was created successfully!");
        lsValMAPForm.setManId(form.getManId());
        lsValMAPForm.setActionClass(form.getActionClass());
        lsValMAPForm.setManId(form.getManId());

        return Response.ok("redirect:events").build();
    }

    @GET @Path("response")
    public Response helloResponse() {
        return Response.status(Response.Status.OK)
            .entity("hello.jsp")
            .build();
    }
}