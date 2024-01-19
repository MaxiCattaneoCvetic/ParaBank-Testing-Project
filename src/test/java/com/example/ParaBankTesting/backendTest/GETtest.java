package com.example.ParaBankTesting.backendTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GETtest {



    @Test
    // podemos utilizar las palabras claves de BDD
    public void get_test01() {
        // dada la web, luego de ingresar deberia tener status 200
        given().get("https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All").then().statusCode(200).log().body();
    }


    @Test
    // podemos utilizar las palabras claves de BDD
    public void get_test02() {
        // dada la web, luego de ingresar deberia tener status 200
        given().get("https://parabank.parasoft.com/parabank/register.htm").then().statusCode(200).log().body();
    }
}

