package com.api.automation;

import com.api.automation.assertions.AuthenticatedUserAssertions;
import com.api.automation.base.BaseTest;
import com.api.automation.models.AuthenticatedUser;
import com.api.automation.services.AuthenticatedUserService;
import com.api.automation.specification.ResponseSpec;
import com.api.automation.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AuthAPITest extends BaseTest {

    private final AuthenticatedUserService authUserService = new AuthenticatedUserService();

    @Test(groups = {"smoke" , "regression"})
    public void getAuthenticatedUserTest() {
      Response response =  authUserService.getAuthenticatedUser();
      response.then().spec(ResponseSpec.statusCode200());
      AuthenticatedUser expectedUser = JsonUtils.readJsonFile("testdata/users/AuthenticatedUserDetails.json",AuthenticatedUser.class);
      AuthenticatedUser actualUser = response.as(AuthenticatedUser.class);
        AuthenticatedUserAssertions.assertAuthenticatedUserEquals(actualUser,expectedUser);
    }
}
