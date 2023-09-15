package API.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class TrelloStepdefinition {

    @Given("I create a board on Trello")
    public void ı_create_a_board_on_trello() {
        RestAssured.baseURI = "https://api.trello.com/1";

        Response res = given()
                .contentType(ContentType.JSON)
                .queryParam("name", "APITest")
                .queryParam("key", "APIKey")
                .queryParam("token", "APIToken")
                .when()
                .post("/boards");

        res.prettyPrint();

        res.then().statusCode(200);
    }
    @Given("I create two cards on the board")
    public void ı_create_two_cards_on_the_board() {
        RestAssured.baseURI = "https://api.trello.com/1";

        for (int i = 0; i < 2; i++) {

            Response response = given()
                    .contentType(ContentType.JSON)
                    .queryParam("idList", "CardName"+(i+1))
                    .queryParam("key", "APIKey")
                    .queryParam("token", "APIToken")
                    .header("Accept", "application/json")
                    .when()
                    .post("/cards");

            response.prettyPrint();

            response.then().statusCode(200);
        }
    }
    @When("I update one card randomly")
    public void ı_update_one_card_randomly() {
        RestAssured.baseURI = "https://api.trello.com/1";


        Random random = new Random();
        int randomId = random.nextInt(2);

        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("key", "APIKey")
                .queryParam("token", "APIToken")
                .header("Accept", "application/json")
                .when()
                .put("/cards/" + randomId);

        response.prettyPrint();

        response.then().statusCode(200);
    }
    @Then("I delete the cards")
    public void ı_delete_the_cards() {
        RestAssured.baseURI = "https://api.trello.com/1";

        for (int i = 0; i < 2; i++) {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .queryParam("key", "APIKey")
                    .queryParam("token", "APIToken")
                    .when()
                    .delete("/cards/" +i);

            response.prettyPrint();
            response.then().statusCode(200);
        }
    }
    @Then("I delete the board")
    public void ı_delete_the_board() {
        RestAssured.baseURI = "https://api.trello.com/1";

        String boardId = "#####????";

        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("key", "APIKey")
                .queryParam("token", "APIToken")
                .when()
                .delete("/boards/" + boardId);

        response.prettyPrint();

        response.then().statusCode(200);
    }

}
