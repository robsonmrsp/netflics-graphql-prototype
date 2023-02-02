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
import br.com.netflics.model.Company;
import br.com.netflics.fixture.FixtureUtils;
import br.com.six2six.fixturefactory.Fixture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:init-data-Company.sql")
public class CompanyControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	private static final String URL = "/rs/crud/companys";

	@BeforeAll
	public static void setUp() {
		FixtureUtils.init();
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void testAddCompany() throws Exception {

		Company company = Fixture.from(Company.class).gimme("novo");
		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Company> responseEntity = withBasicAuth.postForEntity(URL, company, Company.class);

		HttpStatus status = responseEntity.getStatusCode();
		Company resultCompany = responseEntity.getBody();

		assertEquals("Incorrect Response Status: ", HttpStatus.CREATED, status);
		assertNotNull("A not null gender should be returned: ", resultCompany);
		assertNotNull("A not null gender identifier should be returned:", resultCompany.getId());
	}

	@Test
	public void testGetCompany() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Company> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Company.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();
		Company resultCompany = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultCompany);
		assertEquals("A id gender == 1 must be returned: ", resultCompany.getId(), new Integer(1));
	}

	@Test
	public void testGetPagerCompany() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager> responseEntity = withBasicAuth.getForEntity(URL, Pager.class);

		HttpStatus status = responseEntity.getStatusCode();
		Pager<Company> resultPagerCompany = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultPagerCompany);
	}

	@Test
	public void testGetCompanyNotExist() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Company> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Company.class, new Long(100));

		HttpStatus status = responseEntity.getStatusCode();
		Company resultCompany = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND, status);
		assertNull(resultCompany);
	}

	@Test
	public void testGetCompanyByParameter() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager<Company>> responseEntity = withBasicAuth.exchange(URL + "?name={name}", HttpMethod.GET, null, new ParameterizedTypeReference<Pager<Company>>() {}, "name company1");
		Pager<Company> companys = responseEntity.getBody();
		HttpStatus status = responseEntity.getStatusCode();

		companys.getItems().forEach(new Consumer<Company>() {
			@Override
			public void accept(Company company) {
				assertEquals("A not null Company should be returned white the 'name' = 'name company1'", company.getName(), "name company1");
			}
		});

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertTrue("A Array of Company should be returned ", companys.getItems().size() > 0);
	}
	
	@Test
	public void testUpdateCompany() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		Company company = Fixture.from(Company.class).gimme("novo");
		company.setId(1);

		HttpEntity<Company> requestEntity = new HttpEntity<Company>(company);

		ResponseEntity<Company> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity, Company.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);

	}

	@Test
	public void testDeleteCompany() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Boolean> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.DELETE, null, Boolean.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		ResponseEntity<Company> responseTesteDelete = withBasicAuth.getForEntity(URL + "/{id}", Company.class, new Integer(1));

		HttpStatus responseTesteDeleteStatus = responseTesteDelete.getStatusCode();
		Company resultCompany = responseTesteDelete.getBody();

		assertEquals("Incorrect Response Status after delete the company id = 1", HttpStatus.NOT_FOUND, responseTesteDeleteStatus);
		assertNull(resultCompany);

		assertEquals("Incorrect Response Status", HttpStatus.NO_CONTENT, status);

	}
	
	@TestConfiguration
	static class MyTestConfig {

	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21