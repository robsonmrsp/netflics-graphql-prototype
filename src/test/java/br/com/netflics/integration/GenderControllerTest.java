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
import br.com.netflics.model.Gender;
import br.com.netflics.fixture.FixtureUtils;
import br.com.six2six.fixturefactory.Fixture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:init-data-Gender.sql")
public class GenderControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	private static final String URL = "/rs/crud/genders";

	@BeforeAll
	public static void setUp() {
		FixtureUtils.init();
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void testAddGender() throws Exception {

		Gender gender = Fixture.from(Gender.class).gimme("novo");
		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Gender> responseEntity = withBasicAuth.postForEntity(URL, gender, Gender.class);

		HttpStatus status = responseEntity.getStatusCode();
		Gender resultGender = responseEntity.getBody();

		assertEquals("Incorrect Response Status: ", HttpStatus.CREATED, status);
		assertNotNull("A not null gender should be returned: ", resultGender);
		assertNotNull("A not null gender identifier should be returned:", resultGender.getId());
	}

	@Test
	public void testGetGender() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Gender> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Gender.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();
		Gender resultGender = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultGender);
		assertEquals("A id gender == 1 must be returned: ", resultGender.getId(), new Integer(1));
	}

	@Test
	public void testGetPagerGender() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager> responseEntity = withBasicAuth.getForEntity(URL, Pager.class);

		HttpStatus status = responseEntity.getStatusCode();
		Pager<Gender> resultPagerGender = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultPagerGender);
	}

	@Test
	public void testGetGenderNotExist() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Gender> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Gender.class, new Long(100));

		HttpStatus status = responseEntity.getStatusCode();
		Gender resultGender = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND, status);
		assertNull(resultGender);
	}

	@Test
	public void testGetGenderByParameter() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager<Gender>> responseEntity = withBasicAuth.exchange(URL + "?gender={gender}", HttpMethod.GET, null, new ParameterizedTypeReference<Pager<Gender>>() {}, "gender gender1");
		Pager<Gender> genders = responseEntity.getBody();
		HttpStatus status = responseEntity.getStatusCode();

		genders.getItems().forEach(new Consumer<Gender>() {
			@Override
			public void accept(Gender gender) {
				assertEquals("A not null Gender should be returned white the 'name' = 'gender gender1'", gender.getGender(), "gender gender1");
			}
		});

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertTrue("A Array of Gender should be returned ", genders.getItems().size() > 0);
	}
	
	@Test
	public void testUpdateGender() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		Gender gender = Fixture.from(Gender.class).gimme("novo");
		gender.setId(1);

		HttpEntity<Gender> requestEntity = new HttpEntity<Gender>(gender);

		ResponseEntity<Gender> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity, Gender.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);

	}

	@Test
	public void testDeleteGender() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Boolean> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.DELETE, null, Boolean.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		ResponseEntity<Gender> responseTesteDelete = withBasicAuth.getForEntity(URL + "/{id}", Gender.class, new Integer(1));

		HttpStatus responseTesteDeleteStatus = responseTesteDelete.getStatusCode();
		Gender resultGender = responseTesteDelete.getBody();

		assertEquals("Incorrect Response Status after delete the gender id = 1", HttpStatus.NOT_FOUND, responseTesteDeleteStatus);
		assertNull(resultGender);

		assertEquals("Incorrect Response Status", HttpStatus.NO_CONTENT, status);

	}
	
	@TestConfiguration
	static class MyTestConfig {

	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21