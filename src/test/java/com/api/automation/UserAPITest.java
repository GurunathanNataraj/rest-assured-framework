package com.api.automation;


import com.api.automation.assertions.UserAssertions;
import com.api.automation.base.BaseTest;
import com.api.automation.models.User;
import com.api.automation.models.UserPatchRequest;
import com.api.automation.services.UserService;
import com.api.automation.specification.ResponseSpec;
import com.api.automation.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserAPITest extends BaseTest {

    private final UserService userService = new UserService();

    @Test(groups = {"smoke","regression"})
    public void getUserTest() {

       Response response = userService.getUserById(1);

                response.then()
                .spec(ResponseSpec.statusCode200());

        User expectedUser = JsonUtils.readJsonFile("testdata/users/user_1.json", User.class);
        User actualUser = response.as(User.class);
        UserAssertions.assertUserEquals(actualUser,expectedUser);
    }

    @Test(groups = {"regression"})
    public void getUserNotFoundTest() {
        Response response = userService.getUserById(99999);
        response.then()
                .spec(ResponseSpec.statusCode404());
    }

    @Test(groups = {"smoke","regression"})
    public void createUserTest() {
        User newUser = JsonUtils.readJsonFile("testdata/users/create_user.json", User.class);
        Response response = userService.createUser(newUser);
        response.then().spec(ResponseSpec.statusCode201());
        User createdUser = response.as(User.class);
        UserAssertions.assertBasicUserFields(createdUser,newUser);
    }

    @Test(groups = {"regression"})
    public void updateUserTest() {
        User updateUser = JsonUtils.readJsonFile("testdata/users/user_update.json", User.class);
        Response response = userService.updateUser(1,updateUser);
        response.then().spec(ResponseSpec.statusCode200());
        User updatedUser = response.as(User.class);
        UserAssertions.assertUserName(updatedUser,updateUser);
        UserAssertions.assertUserAddressStreet(updatedUser,updateUser);
    }

    @Test(groups = {"regression"})
    public void deleteUserTest() {
        Response response = userService.deleteUser(1);
        response.then()
                .spec(ResponseSpec.statusCode200());
    }

    @Test(groups = {"regression"})
    public void patchUserTest() {
        UserPatchRequest patchRequestUser = JsonUtils.readJsonFile("testdata/users/user_patch.json", UserPatchRequest.class);
        Response response = userService.patchUser(1, patchRequestUser);
        response.then()
                .spec(ResponseSpec.statusCode200());
        User patchedUser = response.as(User.class);
        UserAssertions.assertPatchedUserName(patchedUser,patchRequestUser);
    }

    @Test(dataProvider = "userLookupData", groups = {"regression"})
    public void userLookUpTest(int userId, int expectedStatusCode) {
       Response response = userService.getUserById(userId);
       response.then().spec(ResponseSpec.statusCode(expectedStatusCode));
    }

    @DataProvider(name = "userLookupData")
    public Object[][] userLookupData() {
        return new Object[][] {
                {1,200},{2,200},{99999,404}
        };
    }
}
