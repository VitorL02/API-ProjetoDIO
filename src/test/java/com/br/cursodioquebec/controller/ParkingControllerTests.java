package com.br.cursodioquebec.controller;

import com.br.cursodioquebec.controller.dto.ParkingCreateDTO;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.awt.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTests {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given().when()
                .get("/parking")
                .then()
                .statusCode(200);
    }

    @Test
    void whenCreateIsSucess() {

        var parkingDTOTest= new ParkingCreateDTO();
        parkingDTOTest.setColor("Amarelo");
        parkingDTOTest.setLicense("AEWQEQW-10");
        parkingDTOTest.setState("MG");
        parkingDTOTest.setModel("Golzinho");

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(parkingDTOTest)
                .post("/parking")
                .then()
                .statusCode(201)
                .body("license", Matchers.equalTo("AEWQEQW-10"))
                .extract()
                .response()
                .body()
                .prettyPeek();
    }
}