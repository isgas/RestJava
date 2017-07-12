package com.rest.organizer.Organizations;

import com.rest.organizer.Database.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;



public class OrganizationsAction {

    private Connection connection;

    public OrganizationsAction(){
        connection = new DatabaseConnection().getConnection();
    }

    public ArrayList getOrganizations(){
        return new OrganizationsDao(connection).getOrganizations();
    }


    public OrganizationsDto getOrganization(String id){
        OrganizationsDao organizationsDao = new OrganizationsDao(connection);
        organizationsDao.getOrganizations();
        return organizationsDao.getOrganization(id);

    }

    public boolean addOrganization(OrganizationsDto organizationsDto){


        return new OrganizationsDao(connection).addOrganization(organizationsDto);
    }



}
