package com.rest.organizer.Organizations;

import com.rest.organizer.Database.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Fagan on 7/8/2017.
 */
public class OrganizationsModel {
    private Connection connection;

    public OrganizationsModel(){
        connection = new DatabaseConnection().getConnection();
    }

    public ArrayList getOrganizations(){
        return new OrganizationsDao(connection).getOrganizations();
    }


    public OrganizationsDto getOrganization(String id){

        return new OrganizationsDao(connection).getOrganization(id);

    }


}