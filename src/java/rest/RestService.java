package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import facade.Facade;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("qoute")
public class RestService {

    Gson gson;
    Random random = new Random();

    @Context
    private UriInfo context;

    public RestService() {
        gson = new GsonBuilder().
                setPrettyPrinting().
                setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).
                create();
    }

    @GET
    @Produces("application/json")
    public String getRandomQoute() {
        int i = random.nextInt(Facade.getMapSize()) + 1;
        return gson.toJson(Facade.getQoute(i));
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getQoute(@PathParam("id") int index) {
        return gson.toJson(Facade.getQoute(index));
    }

    @POST
    @Consumes("application/json")
    public void createQoute(String qoute) {
        JsonObject jobj = new Gson().fromJson(qoute, JsonObject.class);
        Facade.createQoute(jobj.get("qoute").getAsString());
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    public void deleteQoute(@PathParam("id") int index) {
        Facade.deleteQoute(index);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void editQoute(@PathParam("id") int index, String qoute) {
        JsonObject jobj = new Gson().fromJson(qoute, JsonObject.class);
        Facade.editQoute(index, jobj.get("qoute").getAsString());
    }

}
