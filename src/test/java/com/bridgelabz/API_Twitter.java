package com.bridgelabz;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/* Testing Twitter API by Authentication tokens using APi key, API secret, AccessToken, Access Token Secret*/

public class API_Twitter {

    @Test
    public void postTweet() {
        Response response = RestAssured.given().auth().
                oauth("obAlSAV7gbRpYAfcMPHD4DJWi",
                        "JISHIwDzRIEUBPc9IJRxDoQwjhLAPlDlyywve0rLJ8ppAGXZu4",
                        "1528557144702078977-Eil6smA3p13NDualaPs5W3aPRYPeDn",
                        "qHAvQ3RRc8cHM8Z9oCJhDk9X2DXkbWumCaffufyydmJV8").
                post("https://api.twitter.com/1.1/statuses/update.json?status=First Tweet using Twitter API");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Code: " + response.prettyPrint());
        response.getBody().jsonPath().prettify();
        JsonPath jsonPath = response.jsonPath();
        System.out.println("ID: " + jsonPath.get("id_str"));
    }

    @Test
    public void reTweet() {
        Response response = RestAssured.given().auth().
                oauth("obAlSAV7gbRpYAfcMPHD4DJWi",
                        "JISHIwDzRIEUBPc9IJRxDoQwjhLAPlDlyywve0rLJ8ppAGXZu4",
                        "1528557144702078977-Eil6smA3p13NDualaPs5W3aPRYPeDn",
                        "qHAvQ3RRc8cHM8Z9oCJhDk9X2DXkbWumCaffufyydmJV8").
                post("https://api.twitter.com/1.1/statuses/retweet/1528961107569758208.json");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Code: " + response.prettyPrint());
        response.getBody().jsonPath().prettify();
        JsonPath jsonPath = response.jsonPath();
        System.out.println("ID: " + jsonPath.get("id_str"));
    }

    @Test
    public void deleteTweet() {
        Response response = RestAssured.given().auth().
                oauth("obAlSAV7gbRpYAfcMPHD4DJWi",
                        "JISHIwDzRIEUBPc9IJRxDoQwjhLAPlDlyywve0rLJ8ppAGXZu4",
                        "1528557144702078977-Eil6smA3p13NDualaPs5W3aPRYPeDn",
                        "qHAvQ3RRc8cHM8Z9oCJhDk9X2DXkbWumCaffufyydmJV8").
                delete("https://api.twitter.com/2/tweets/1528961107569758208");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Code: " + response.prettyPrint());
    }
}
