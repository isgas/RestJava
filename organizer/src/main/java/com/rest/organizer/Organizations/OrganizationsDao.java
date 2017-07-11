package com.rest.organizer.Organizations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrganizationsDao {
    private String sqlQuery;
    private ArrayList<OrganizationsDto> arrayList = new ArrayList<>();
    private Statement statement;
    private OrganizationsDto organizationsDto;

    public OrganizationsDao(Connection connection) {
        sqlQuery = "select * from prjct_organizations";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                organizationsDto = new OrganizationsDto(
                        resultSet.getString("organization_id"),
                        resultSet.getString("organization_name"),
                        resultSet.getString("organization_createdat"),
                        resultSet.getString("organization_logo")

                );
                arrayList.add(organizationsDto);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList getOrganizations(){

       if (arrayList.size() > 0)
           return arrayList;
       else
           return null;

    }

    public OrganizationsDto getOrganization(String id){
        for (OrganizationsDto organization:arrayList) {
            if (id.equals(organization.getId())){
                return organization;
            }

        }
        return null;
    }
}
