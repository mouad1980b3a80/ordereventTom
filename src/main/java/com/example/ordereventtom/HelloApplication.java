package com.example.ordereventtom;

import java.util.HashSet;
import java.util.Set;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.krazo.binding.convert.MvcConverterProvider;
import org.eclipse.krazo.core.ViewResponseFilter;
import org.eclipse.krazo.core.ViewableWriter;
import org.eclipse.krazo.forms.HiddenMethodFilter;
import org.eclipse.krazo.jaxrs.PostMatchingRequestFilter;
import org.eclipse.krazo.jaxrs.PreMatchingRequestFilter;
import org.eclipse.krazo.security.CsrfExceptionMapper;
import org.eclipse.krazo.security.CsrfProtectFilter;
import org.eclipse.krazo.security.CsrfValidateFilter;
import com.example.controller.HelloController;
import com.example.controller.LsValMAPController;
import com.example.controller.OrderEventsController;
import com.example.controller.OrderEventsFilterController;

@ApplicationScoped
@ApplicationPath("/ui")
public class HelloApplication extends Application {

    // TODO comment this when needed
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(LsValMAPController.class);
        classes.add(HelloController.class);
        classes.add(OrderEventsController.class);
        classes.add(OrderEventsFilterController.class);
        //  classes.add(TaskController.class);
      /*  classes.add(GreetingController.class);
        classes.add(LocaleController.class);
        classes.add(PrimitiveConverterProvider.class);
        classes.add(PostNotFoundExceptionMapper.class);

       */

        // add krazo feature.
        classes.add(ViewResponseFilter.class);
        classes.add(ViewableWriter.class);
        classes.add(CsrfValidateFilter.class);
        classes.add(CsrfProtectFilter.class);
        classes.add(CsrfExceptionMapper.class);
        classes.add(PreMatchingRequestFilter.class);
        classes.add(PostMatchingRequestFilter.class);
        classes.add(MvcConverterProvider.class);
        classes.add(HiddenMethodFilter.class);
        //classes.add(com.example.workaround.LibertyUnwrapper.class);
        // classes.add(ContainerRequestFilter.class);

        return classes;
    }
}