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
import br.com.netflics.model.Department;
import br.com.netflics.fixture.FixtureUtils;
import br.com.six2six.fixturefactory.Fixture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:init-data-Department.sql")
public class DepartmentControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	private static final String URL = "/rs/crud/departments";

	@BeforeAll
	public static void setUp() {
		FixtureUtils.init();
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void testAddDepartment() throws Exception {

		Department department = Fixture.from(Department.class).gimme("novo");
		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Department> responseEntity = withBasicAuth.postForEntity(URL, department, Department.class);

		HttpStatus status = responseEntity.getStatusCode();
		Department resultDepartment = responseEntity.getBody();

		assertEquals("Incorrect Response Status: ", HttpStatus.CREATED, status);
		assertNotNull("A not null gender should be returned: ", resultDepartment);
		assertNotNull("A not null gender identifier should be returned:", resultDepartment.getId());
	}

	@Test
	public void testGetDepartment() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Department> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Department.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();
		Department resultDepartment = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultDepartment);
		assertEquals("A id gender == 1 must be returned: ", resultDepartment.getId(), new Integer(1));
	}

	@Test
	public void testGetPagerDepartment() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager> responseEntity = withBasicAuth.getForEntity(URL, Pager.class);

		HttpStatus status = responseEntity.getStatusCode();
		Pager<Department> resultPagerDepartment = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultPagerDepartment);
	}

	@Test
	public void testGetDepartmentNotExist() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Department> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Department.class, new Long(100));

		HttpStatus status = responseEntity.getStatusCode();
		Department resultDepartment = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND, status);
		assertNull(resultDepartment);
	}

	@Test
	public void testGetDepartmentByParameter() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager<Department>> responseEntity = withBasicAuth.exchange(URL + "?departmentName={departmentName}", HttpMethod.GET, null, new ParameterizedTypeReference<Pager<Department>>() {}, "departmentName department1");
		Pager<Department> departments = responseEntity.getBody();
		HttpStatus status = responseEntity.getStatusCode();

		departments.getItems().forEach(new Consumer<Department>() {
			@Override
			public void accept(Department department) {
				assertEquals("A not null Department should be returned white the 'name' = 'departmentName department1'", department.getDepartmentName(), "departmentName department1");
			}
		});

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertTrue("A Array of Department should be returned ", departments.getItems().size() > 0);
	}
	
	@Test
	public void testUpdateDepartment() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		Department department = Fixture.from(Department.class).gimme("novo");
		department.setId(1);

		HttpEntity<Department> requestEntity = new HttpEntity<Department>(department);

		ResponseEntity<Department> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity, Department.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);

	}

	@Test
	public void testDeleteDepartment() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Boolean> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.DELETE, null, Boolean.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		ResponseEntity<Department> responseTesteDelete = withBasicAuth.getForEntity(URL + "/{id}", Department.class, new Integer(1));

		HttpStatus responseTesteDeleteStatus = responseTesteDelete.getStatusCode();
		Department resultDepartment = responseTesteDelete.getBody();

		assertEquals("Incorrect Response Status after delete the department id = 1", HttpStatus.NOT_FOUND, responseTesteDeleteStatus);
		assertNull(resultDepartment);

		assertEquals("Incorrect Response Status", HttpStatus.NO_CONTENT, status);

	}
	
	@TestConfiguration
	static class MyTestConfig {

	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21