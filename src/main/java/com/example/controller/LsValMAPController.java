package com.example.controller;


import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import java.util.ArrayList;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.krazo.engine.Viewable;
import com.example.domain.LsValMAPRepository;
import com.example.domain.TestLsValMAP;
import com.example.domain.LsValMAPRepository;
import com.example.web.AlertMessage;
import com.example.web.LsValMAPForm;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.mvc.security.CsrfProtected;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("tasks")
@Controller
@RequestScoped
public class LsValMAPController {



    @Inject
    private Models models;

    @Inject
    private BindingResult validationResult;

    @Inject
    LsValMAPRepository lsValMAPRepository;


    AlertMessage flashMessage;


    @GET
    @View("lsvalmap.xhtml")
    public void allLsValMAPs() {
        //log.log(Level.INFO, "fetching all LsValMAPs");
        /*if (lsValMAPRepository == null) {
            lsValMAPRepository = new LsValMAPRepository();
        }
        List<TestLsValMAP> todolsValMAPs = lsValMAPRepository.findAll();

         */



       // log.log(Level.INFO, "got all LsValMAPs: todolsValMAPs@{0}", new Object[]{todolsValMAPs.size()});

        models.put("allLsValMAPs", new ArrayList<>());


    }

    @GET
    @Path("{id}")
    public Viewable lsValMAPDetails(@PathParam("id") @NotNull Long id) {
       // log.log(Level.INFO, "get lsValMAP by id@{0}", id);
        TestLsValMAP lsValMAP = lsValMAPRepository.findById(id);

        models.put("details", lsValMAP);
        return new Viewable("details.xhtml");
    }

    @GET
    @Path("add")
    public Viewable add() {
        //log.log(Level.INFO, "add new lsValMAP");
        LsValMAPForm form = new LsValMAPForm();
        models.put("lsValMAP", form);
        return new Viewable("add.xhtml");
    }

    @GET
    @Path("add2")
    public Viewable add2() {
        //log.log(Level.INFO, "add new lsValMAP");
        LsValMAPForm form = new LsValMAPForm();
        models.put("lsValMAP", form);
        return new Viewable("add.xhtml");
    }

    @POST
    @CsrfProtected
    //@ValidateOnExecution(type = ExecutableType.NONE)
    public Response save(@Valid @BeanParam LsValMAPForm form) {
        //log.log(Level.INFO, "saving new lsValMAP @{0}", form);

        if (validationResult.isFailed()) {
            AlertMessage alert = AlertMessage.danger("Validation voilations!");
            validationResult.getAllErrors()
                    .stream()
                    .forEach((ParamError t) -> {
                        alert.addError(t.getParamName(), "", t.getMessage());
                    });
            models.put("errors", alert);
            models.put("lsValMAP", form);
            return Response.status(BAD_REQUEST).entity("add.xhtml").build();
        }

        TestLsValMAP lsValMAP = new TestLsValMAP();
       // lsValMAP.setMapq(form.getValueOrig());
       // lsValMAP.setValueOrig(form.getMapq());

        lsValMAPRepository.save(lsValMAP);

       // flashMessage.notify(Type.success, "lsValMAP was created successfully!");

        return Response.ok("redirect:lsValMAPs").build();
    }

    @GET
    @Path("{id}/edit")
    public Viewable edit(@PathParam("id") Long id) {
       /// log.log(Level.INFO, "edit lsValMAP @{0}", id);

        TestLsValMAP lsValMAP = lsValMAPRepository.findById(id);

        LsValMAPForm form = new LsValMAPForm();
        //form.setMapid(lsValMAP.getMapid());
        //form.setValueOrig(lsValMAP.getValueOrig());
        //form.setMapq(lsValMAP.getMapq());
        models.put("lsValMAP", form);
        return new Viewable("edit.xhtml");
    }

    @PUT
    @Path("{id}")
    @CsrfProtected
    public Response update(@PathParam(value = "id") Long id, @Valid @BeanParam LsValMAPForm form) {
       // log.log(Level.INFO, "updating existed lsValMAP@id:{0}, form data:{1}", new Object[]{id, form});

        if (validationResult.isFailed()) {
            AlertMessage alert = AlertMessage.danger("Validation voilations!");
            validationResult.getAllErrors()
                    .stream()
                    .forEach((ParamError t) -> {
                        alert.addError(t.getParamName(), "", t.getMessage());
                    });
            models.put("errors", alert);
            models.put("lsValMAP", form);
            return Response.status(BAD_REQUEST).entity("edit.xhtml").build();
        }

        TestLsValMAP lsValMAP = lsValMAPRepository.findById(id);

        //lsValMAP.setValueOrig(form.getValueOrig());
        //lsValMAP.setMapq(form.getMapq());

        lsValMAPRepository.update(lsValMAP);

       // flashMessage.notify(Type.info, "lsValMAP was updated successfully!");

        return Response.ok("redirect:lsValMAPs").build();
    }

   /* @PUT
    @Path("{id}/status")
    //@CsrfProtected
    public Response updateStatus(@PathParam(value = "id") Long id, @NotNull @FormParam(value = "status") String status) {
        log.log(Level.INFO, "updating status of the existed lsValMAP@id:{0}, status:{1}", new Object[]{id, status});

        LsValMAP lsValMAP = lsValMAPRepository.findById(id);

        lsValMAP.setStatus(lsValMAP.Status.valueOf(status));

        lsValMAPRepository.update(lsValMAP);

        //flashMessage.notify(Type.info, "lsValMAP status was updated successfully!");

        return Response.ok("redirect:lsValMAPs").build();
    }*/

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        //log.log(Level.INFO, "deleting lsValMAP @{0}", id);
        TestLsValMAP lsValMAP = lsValMAPRepository.findById(id);
        lsValMAPRepository.delete(lsValMAP);

       // AlertMessage flashMessage = AlertMessage.danger("lsValMAP was deleted!");
        //models.put("flashMessage", flashMessage);
        return Response.ok("redirect:lsValMAPs").build();
    }

    @PostConstruct
    private void init() {
       // log.config(() -> this.getClass().getSimpleName() + " created");
    }
}
