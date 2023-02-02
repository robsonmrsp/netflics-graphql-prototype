/** generated: 1 de fev de 2023 23:43:21 **/
package br.com.netflics.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.netflics.core.persistence.pagination.Pager;
import br.com.netflics.model.Country;
import br.com.netflics.fixture.FixtureUtils;
import br.com.six2six.fixturefactory.Fixture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:init-data-Country.sql")
public class CountryControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	private static final String URL = "/rs/crud/countrys";

	@BeforeAll
	public static void setUp() {
		FixtureUtils.init();
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void testAddCountry() throws Exception {

		Country country = Fixture.from(Country.class).gimme("novo");
		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Country> responseEntity = withBasicAuth.postForEntity(URL, country, Country.class);

		HttpStatus status = responseEntity.getStatusCode();
		Country resultCountry = responseEntity.getBody();

		assertEquals("Incorrect Response Status: ", HttpStatus.CREATED, status);
		assertNotNull("A not null gender should be returned: ", resultCountry);
		assertNotNull("A not null gender identifier should be returned:", resultCountry.getId());
	}

	@Test
	public void testGetCountry() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Country> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Country.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();
		Country resultCountry = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultCountry);
		assertEquals("A id gender == 1 must be returned: ", resultCountry.getId(), new Integer(1));
	}

	@Test
	public void testGetPagerCountry() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager> responseEntity = withBasicAuth.getForEntity(URL, Pager.class);

		HttpStatus status = responseEntity.getStatusCode();
		Pager<Country> resultPagerCountry = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultPagerCountry);
	}

	@Test
	public void testGetCountryNotExist() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Country> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Country.class, new Long(100));

		HttpStatus status = responseEntity.getStatusCode();
		Country resultCountry = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND, status);
		assertNull(resultCountry);
	}

	@Test
	public void testGetCountryByParameter() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager<Country>> responseEntity = withBasicAuth.exchange(URL + "?name={name}", HttpMethod.GET, null, new ParameterizedTypeReference<Pager<Country>>() {}, "name country1");
		Pager<Country> countrys = responseEntity.getBody();
		HttpStatus status = responseEntity.getStatusCode();

		countrys.getItems().forEach(new Consumer<Country>() {
			@Override
			public void accept(Country country) {
				assertEquals("A not null Country should be returned white the 'name' = 'name country1'", country.getName(), "name country1");
			}
		});

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertTrue("A Array of Country should be returned ", countrys.getItems().size() > 0);
	}
	
	@Test
	public void testUpdateCountry() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		Country country = Fixture.from(Country.class).gimme("novo");
		country.setId(1);

		HttpEntity<Country> requestEntity = new HttpEntity<Country>(country);

		ResponseEntity<Country> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity, Country.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);

	}

	@Test
	public void testDeleteCountry() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Boolean> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.DELETE, null, Boolean.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		ResponseEntity<Country> responseTesteDelete = withBasicAuth.getForEntity(URL + "/{id}", Country.class, new Integer(1));

		HttpStatus responseTesteDeleteStatus = responseTesteDelete.getStatusCode();
		Country resultCountry = responseTesteDelete.getBody();

		assertEquals("Incorrect Response Status after delete the country id = 1", HttpStatus.NOT_FOUND, responseTesteDeleteStatus);
		assertNull(resultCountry);

		assertEquals("Incorrect Response Status", HttpStatus.NO_CONTENT, status);

	}
	
	@TestConfiguration
	static class MyTestConfig {

	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21