package sk.js.spring.jersey2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import sk.js.spring.jersey2.api.resource.DummyResource;
import sk.js.spring.jersey2.api.service.DummyService;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("dummy")
public class DummyResourceImpl implements DummyResource {

    @Autowired
    private DummyService dummyService;

    @Override
    public Response getDummyName() {
        return Response.ok(dummyService.getName()).build();
    }

    @Override
    public Response getAnotherName() {
        return Response.ok("another dummy name.").build();
    }
}
