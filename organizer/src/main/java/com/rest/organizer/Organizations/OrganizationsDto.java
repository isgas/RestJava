package com.rest.organizer.Organizations;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fagan on 7/8/2017.
 */
public class OrganizationsDto {
    private String id;
    private String name;
    private String date;
    private String logo_path;

    public OrganizationsDto(String id, String name, String date, String logo_path) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.logo_path = logo_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

}
