package com.rest.organizer.Organizations;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrganizationsDao {
    private Connection connection;
    private String sqlQuery;
    private ArrayList<OrganizationsDto> arrayList = new ArrayList<>();
    private Statement statement;
    private OrganizationsDto organizationsDto;
    private String tableName = "prjct_organizations";

    public OrganizationsDao(Connection connection) {
        this.connection = connection;

    }


    public ArrayList getOrganizations(){
        sqlQuery = "select * from "+tableName;
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


    public boolean addOrganization(OrganizationsDto organizationsDto){
        // TODO: 7/12/2017 Sql query build , Put only connection to OrganizationsDao constructor


        try {
            statement = connection.createStatement();
            sqlQuery = "insert into "+tableName+" (organization_name,organization_logo)" +
                    " values('"+organizationsDto.getName()+"'"+",'"+organizationsDto.getLogo_path()+"')";
            statement.execute(sqlQuery);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
}
