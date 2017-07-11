package com.rest.organizer.Organizations;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Path("/organizations")
public class OrganizationsService {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getOrganization(){
        Gson gson = new Gson();
        return gson.toJson(new OrganizationsModel().getOrganizations());
    }



    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrganization(@PathParam("id") String id){
        Gson gson = new Gson();
        //return id;
        return gson.toJson(new OrganizationsModel().getOrganization(id));


    }



    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String doPost(OrganizationsDto organizationsDto){


        return organizationsDto.getLogo_path();
    }
    */
}
