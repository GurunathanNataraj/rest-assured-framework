package com.api.automation;


import com.api.automation.base.BaseTest;
import com.api.automation.models.User;
import com.api.automation.services.UserService;
import com.api.automation.specification.ResponseSpec;
import com.api.automation.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class UserAPITest extends BaseTest {

    private final UserService userService = new UserService();

    @Test
    public void getUserTest() {

       Response response = userService.getUserById(1);

                response.then()
                .spec(ResponseSpec.statusCode200());

        User expectedUser = JsonUtils.readJsonFile("testdata/users/user_1.json", User.class);
        User actualUser = response.as(User.class);
        assertEquals(actualUser.getId(), expectedUser.getId());
        assertEquals(actualUser.getName(), expectedUser.getName());
        assertEquals(actualUser.getUsername(), expectedUser.getUsername());
        assertEquals(actualUser.getEmail(), expectedUser.getEmail());
        assertEquals(actualUser.getAddress().getStreet(), expectedUser.getAddress().getStreet());
        assertEquals(actualUser.getAddress().getSuite(), expectedUser.getAddress().getSuite());
        assertEquals(actualUser.getAddress().getCity(), expectedUser.getAddress().getCity());
        assertEquals(actualUser.getAddress().getZipcode(), expectedUser.getAddress().getZipcode());
        assertEquals(actualUser.getAddress().getGeo().getLat(),expectedUser.getAddress().getGeo().getLat());
        assertEquals(actualUser.getAddress().getGeo().getLng(),expectedUser.getAddress().getGeo().getLng());
        assertEquals(actualUser.getPhone(),expectedUser.getPhone());
        assertEquals(actualUser.getWebsite(), expectedUser.getWebsite());
        assertEquals(actualUser.getCompany().getName(), expectedUser.getCompany().getName());
        assertEquals(actualUser.getCompany().getCatchPhrase(), expectedUser.getCompany().getCatchPhrase());
        assertEquals(actualUser.getCompany().getBs(), expectedUser.getCompany().getBs());
    }

    @Test
    public void getUserNotFoundTest() {
        Response response = userService.getUserById(99999);
        response.then()
                .spec(ResponseSpec.statusCode404());
    }

    @Test
    public void createUserTest() {
        User newUser = JsonUtils.readJsonFile("testdata/users/create_user.json", User.class);
        Response response = userService.createUser(newUser);
        response.then().spec(ResponseSpec.statusCode201());
        User createdUser = response.as(User.class);
        assertEquals(createdUser.getName(), newUser.getName());
        assertEquals(createdUser.getUsername(), newUser.getUsername());
        assertEquals(createdUser.getEmail(), newUser.getEmail());
    }

    @Test
    public void updateUserTest() {
        User updateUser = JsonUtils.readJsonFile("testdata/users/user_update.json", User.class);
        Response response = userService.updateUser(1,updateUser);
        response.then().spec(ResponseSpec.statusCode200());
        User updatedUser = response.as(User.class);
        assertEquals(updatedUser.getName(),updateUser.getName());
        assertEquals(updatedUser.getAddress().getStreet(), updateUser.getAddress().getStreet());
    }

    @Test
    public void deleteUserTest() {
        Response response = userService.deleteUser(1);
        response.then()
                .spec(ResponseSpec.statusCode200());
    }

    @Test
    public void patchUserTest() {
        User patchRequestUser = JsonUtils.readJsonFile("testdata/users/user_patch.json", User.class);
        Response response = userService.patchUser(1, patchRequestUser);
        response.then()
                .spec(ResponseSpec.statusCode200());
        User patchedUser = response.as(User.class);
        assertEquals(patchedUser.getName(), patchRequestUser.getName());
    }

}
