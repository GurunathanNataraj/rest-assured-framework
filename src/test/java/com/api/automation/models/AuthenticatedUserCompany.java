package com.api.automation.models;

public class AuthenticatedUserCompany {
    private String department;
    private String name;
    private String title;
    private AuthenticatedUserAddress address;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthenticatedUserAddress getAddress() {
        return address;
    }

    public void setAddress(AuthenticatedUserAddress address) {
        this.address = address;
    }

}
