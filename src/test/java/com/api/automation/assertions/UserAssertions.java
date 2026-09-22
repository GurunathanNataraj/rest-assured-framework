package com.api.automation.assertions;

import com.api.automation.models.User;

import static org.testng.Assert.assertEquals;

public class UserAssertions {
    public static void assertUserEquals(User actualUser,User expectedUser) {
        assertEquals(actualUser.getId(), expectedUser.getId());
        assertEquals(actualUser.getName(), expectedUser.getName());
        assertEquals(actualUser.getUsername(), expectedUser.getUsername());
        assertEquals(actualUser.getEmail(), expectedUser.getEmail());
        assertEquals(actualUser.getAddress().getStreet(), expectedUser.getAddress().getStreet());
        assertEquals(actualUser.getAddress().getSuite(), expectedUser.getAddress().getSuite());
        assertEquals(actualUser.getAddress().getCity(), expectedUser.getAddress().getCity());
        assertEquals(actualUser.getAddress().getZipcode(), expectedUser.getAddress().getZipcode());
        assertEquals(actualUser.getAddress().getGeo().getLat(), expectedUser.getAddress().getGeo().getLat());
        assertEquals(actualUser.getAddress().getGeo().getLng(), expectedUser.getAddress().getGeo().getLng());
        assertEquals(actualUser.getPhone(), expectedUser.getPhone());
        assertEquals(actualUser.getWebsite(), expectedUser.getWebsite());
        assertEquals(actualUser.getCompany().getName(), expectedUser.getCompany().getName());
        assertEquals(actualUser.getCompany().getCatchPhrase(), expectedUser.getCompany().getCatchPhrase());
        assertEquals(actualUser.getCompany().getBs(), expectedUser.getCompany().getBs());
    }

    public static void assertBasicUserFields(User actualUser, User expectedUser) {
        assertEquals(actualUser.getName(), expectedUser.getName());
        assertEquals(actualUser.getUsername(), expectedUser.getUsername());
        assertEquals(actualUser.getEmail(), expectedUser.getEmail());
    }

    public static void assertUserName(User actualUser, User expectedUser) {
        assertEquals(actualUser.getName(), expectedUser.getName());
    }

    public static void assertUserAddressStreet(User actualUser, User expectedUser) {
        assertEquals(actualUser.getAddress().getStreet(), expectedUser.getAddress().getStreet());
    }
}

