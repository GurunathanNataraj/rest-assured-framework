package com.api.automation.assertions;

import com.api.automation.models.AuthenticatedUser;
import static org.testng.Assert.assertEquals;

public class AuthenticatedUserAssertions {

    public static void assertAuthenticatedUserEquals(AuthenticatedUser actualUser, AuthenticatedUser expectedUser) {
        assertEquals(actualUser.getId(), expectedUser.getId(), "id mismatch");
        assertEquals(actualUser.getFirstName(), expectedUser.getFirstName(), "firstName mismatch");
        assertEquals(actualUser.getLastName(), expectedUser.getLastName(), "lastName mismatch");
        assertEquals(actualUser.getMaidenName(), expectedUser.getMaidenName(), "maidenName mismatch");
        assertEquals(actualUser.getAge(), expectedUser.getAge(), "age mismatch");
        assertEquals(actualUser.getGender(), expectedUser.getGender(), "gender mismatch");
        assertEquals(actualUser.getEmail(), expectedUser.getEmail(), "email mismatch");
        assertEquals(actualUser.getPhone(), expectedUser.getPhone(), "phone mismatch");
        assertEquals(actualUser.getUsername(), expectedUser.getUsername(), "username mismatch");
        assertEquals(actualUser.getPassword(), expectedUser.getPassword(), "password mismatch");
        assertEquals(actualUser.getBirthDate(), expectedUser.getBirthDate(), "birthDate mismatch");
        assertEquals(actualUser.getImage(), expectedUser.getImage(), "image mismatch");
        assertEquals(actualUser.getBloodGroup(), expectedUser.getBloodGroup(), "bloodGroup mismatch");
        assertEquals(actualUser.getHeight(), expectedUser.getHeight(), "height mismatch");
        assertEquals(actualUser.getWeight(), expectedUser.getWeight(), "weight mismatch");
        assertEquals(actualUser.getEyeColor(), expectedUser.getEyeColor(), "eyeColor mismatch");
        assertEquals(actualUser.getHair().getColor(), expectedUser.getHair().getColor(), "hair.color mismatch");
        assertEquals(actualUser.getHair().getType(), expectedUser.getHair().getType(), "hair.type mismatch");
        assertEquals(actualUser.getIp(), expectedUser.getIp(), "ip mismatch");
        assertEquals(actualUser.getAddress().getAddress(), expectedUser.getAddress().getAddress(), "address.address mismatch");
        assertEquals(actualUser.getAddress().getCity(), expectedUser.getAddress().getCity(), "address.city mismatch");
        assertEquals(actualUser.getAddress().getState(), expectedUser.getAddress().getState(), "address.state mismatch");
        assertEquals(actualUser.getAddress().getStateCode(), expectedUser.getAddress().getStateCode(), "address.stateCode mismatch");
        assertEquals(actualUser.getAddress().getPostalCode(), expectedUser.getAddress().getPostalCode(), "address.postalCode mismatch");
        assertEquals(actualUser.getAddress().getCoordinates().getLat(), expectedUser.getAddress().getCoordinates().getLat(), "address.coordinates.lat mismatch");
        assertEquals(actualUser.getAddress().getCoordinates().getLng(), expectedUser.getAddress().getCoordinates().getLng(), "address.coordinates.lng mismatch");
        assertEquals(actualUser.getAddress().getCountry(), expectedUser.getAddress().getCountry(), "address.country mismatch");
        assertEquals(actualUser.getMacAddress(), expectedUser.getMacAddress(), "macAddress mismatch");
        assertEquals(actualUser.getUniversity(), expectedUser.getUniversity(), "university mismatch");
        assertEquals(actualUser.getBank().getCardExpire(), expectedUser.getBank().getCardExpire(), "bank.cardExpire mismatch");
        assertEquals(actualUser.getBank().getCardNumber(), expectedUser.getBank().getCardNumber(), "bank.cardNumber mismatch");
        assertEquals(actualUser.getBank().getCardType(), expectedUser.getBank().getCardType(), "bank.cardType mismatch");
        assertEquals(actualUser.getBank().getCurrency(), expectedUser.getBank().getCurrency(), "bank.currency mismatch");
        assertEquals(actualUser.getBank().getIban(), expectedUser.getBank().getIban(), "bank.iban mismatch");
        assertEquals(actualUser.getCompany().getDepartment(), expectedUser.getCompany().getDepartment(), "company.department mismatch");
        assertEquals(actualUser.getCompany().getName(), expectedUser.getCompany().getName(), "company.name mismatch");
        assertEquals(actualUser.getCompany().getTitle(), expectedUser.getCompany().getTitle(), "company.title mismatch");
        assertEquals(actualUser.getCompany().getAddress().getAddress(), expectedUser.getCompany().getAddress().getAddress(), "company.address.address mismatch");
        assertEquals(actualUser.getCompany().getAddress().getCity(), expectedUser.getCompany().getAddress().getCity(), "company.address.city mismatch");
        assertEquals(actualUser.getCompany().getAddress().getState(), expectedUser.getCompany().getAddress().getState(), "company.address.state mismatch");
        assertEquals(actualUser.getCompany().getAddress().getStateCode(), expectedUser.getCompany().getAddress().getStateCode(), "company.address.stateCode mismatch");
        assertEquals(actualUser.getCompany().getAddress().getPostalCode(), expectedUser.getCompany().getAddress().getPostalCode(), "company.address.postalCode mismatch");
        assertEquals(actualUser.getCompany().getAddress().getCoordinates().getLat(), expectedUser.getCompany().getAddress().getCoordinates().getLat(), "company.address.coordinates.lat mismatch");
        assertEquals(actualUser.getCompany().getAddress().getCoordinates().getLng(), expectedUser.getCompany().getAddress().getCoordinates().getLng(), "company.address.coordinates.lng mismatch");
        assertEquals(actualUser.getCompany().getAddress().getCountry(), expectedUser.getCompany().getAddress().getCountry(), "company.address.country mismatch");
        assertEquals(actualUser.getEin(), expectedUser.getEin(), "ein mismatch");
        assertEquals(actualUser.getSsn(), expectedUser.getSsn(), "ssn mismatch");
        assertEquals(actualUser.getUserAgent(), expectedUser.getUserAgent(), "userAgent mismatch");
        assertEquals(actualUser.getCrypto().getCoin(), expectedUser.getCrypto().getCoin(), "crypto.coin mismatch");
        assertEquals(actualUser.getCrypto().getWallet(), expectedUser.getCrypto().getWallet(), "crypto.wallet mismatch");
        assertEquals(actualUser.getCrypto().getNetwork(), expectedUser.getCrypto().getNetwork(), "crypto.network mismatch");
        assertEquals(actualUser.getRole(), expectedUser.getRole(), "role mismatch");

    }
}
