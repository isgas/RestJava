package com.rest.organizer.Organizations;

import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/organizations")
public class OrganizationsService {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getOrganization(){
        Gson gson = new Gson();
        return gson.toJson(new OrganizationsAction().getOrganizations());
    }



    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrganization(@PathParam("id") String id){
        Gson gson = new Gson();

        //return id;
        return gson.toJson(new OrganizationsAction().getOrganization(id));

    }

    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String doPost(String json){
        ObjectMapper mapper = new ObjectMapper();
        OrganizationsDto organizationsDto = new OrganizationsDto();
        try {
            organizationsDto = mapper.readValue(json,OrganizationsDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (new OrganizationsAction().addOrganization(organizationsDto))
            return "added";
        return "not added";
    }

}
