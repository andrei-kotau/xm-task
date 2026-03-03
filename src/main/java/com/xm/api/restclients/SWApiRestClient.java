package com.xm.api.restclients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class SWApiRestClient {
    private static final String baseUri = "https://swapi.dev";

    private RequestSpecification getReqSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setAccept(ContentType.JSON)
                //.log(LogDetail.ALL)
                .build();
    }

    private RequestSpecification getNoUriReqSpec() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                //.log(LogDetail.ALL)
                .build();
    }

    private ResponseSpecification getRespSpec() {
        return new ResponseSpecBuilder()
                //.log(LogDetail.ALL)
                .build();
    }

    public Response getFilms() {
        return given(getReqSpec())
                .when()
                .get("/api/films")
                .then()
                .spec(getRespSpec()).extract().response();
    }

    public Response getPerson(String id) {
        return given(getReqSpec())
                .when()
                .get("/api/people/" + id)
                .then()
                .spec(getRespSpec()).extract().response();
    }

    public Response getAllPeople() {
        return given(getReqSpec())
                .when()
                .get("/api/people/")
                .then()
                .spec(getRespSpec()).extract().response();
    }

    public Response getResponseByUrl(String directUrl) {
        return given(getNoUriReqSpec())
                .when()
                .get(directUrl)
                .then()
                .spec(getRespSpec()).extract().response();
    }
}
