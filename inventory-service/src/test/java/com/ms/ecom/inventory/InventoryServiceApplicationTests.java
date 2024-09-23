package com.ms.ecom.inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mysqlContainer = new MySQLContainer("mysql:9.0.1");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mysqlContainer.start();
	}

	@Test
	void shouldReadInventory(){
		var response = RestAssured.given()
				.when()
				.get("/api/inventory?skuCode=iphone_13&quantity=1")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		Assertions.assertTrue(response);

		var negativeResponse = RestAssured.given()
				.when()
				.get("/api/inventory?skuCode=iphone_15&quantity=1000")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		Assertions.assertFalse(negativeResponse);
	}

}
