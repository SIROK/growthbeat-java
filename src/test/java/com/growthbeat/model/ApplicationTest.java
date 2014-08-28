package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.growthbeat.BaseTest;

public class ApplicationTest extends BaseTest {

	@Test
	public void findById() {
		Application application = growthbeat.findApplicationByApplicationId(testApplication.getId());
		assertEquals(testApplication.getId(), application.getId());
		assertEquals("Java SDK", application.getName());
	}

	@Test
	public void findByAccountId() {
		List<Application> applications = growthbeat.findApplicationsByAccountId(testAccount.getId());
		assertTrue(applications.size() > 0);
	}

	@Test
	public void create() {
		Application application = growthbeat.createApplication("Test App");
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("Test App", application.getName());
	}

	@Test
	public void update() {
		Application application = growthbeat.updateApplication(testApplication.getId(), "Java SDK");
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("Java SDK", application.getName());
	}

}
