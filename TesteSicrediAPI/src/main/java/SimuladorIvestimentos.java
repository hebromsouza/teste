import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SimuladorIvestimentos {

	@Test
	public void TestConsulta() {
		RestAssured
		.given()
		.when()
			.get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador")
		.then()
			.statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("simulador.json"));
	}
}
