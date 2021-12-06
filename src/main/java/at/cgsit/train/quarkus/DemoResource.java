package at.cgsit.train.thomas;

import at.cgsit.train.quarkus.service.DemoServiceDb;
import at.cgsit.train.quarkus.service.DemoServiceNew;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloDemo")
public class DemoResource {
    private static final Logger LOG = Logger.getLogger(DemoResource.class);

    @Inject
    DemoServiceNew service;

    @Inject
    DemoServiceDb servicedb;

    @ConfigProperty(name = "greeting.message")
    String message;

    /**
     * http://localhost:8080/helloDemo/echo/<inputString>
     * @param inputString
     * @return service processed input string
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/echo/{inputString}")
    public String greeting(@PathParam("inputString") String inputString) {
        LOG.debug("log: " + inputString);
        return "Hello [" + servicedb.reverseEcho(inputString ) + "]";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloSimple2() {
        return "Hello helloDemo TEST2";
    }

    @GET
    @Path("/showMessage")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloMicroProfileMessage() {
        return "Hello: " + message;
    }

}