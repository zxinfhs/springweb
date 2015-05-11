package net.zx.testing;


import net.zx.bo.UserManager;
import net.zx.exception.BusinessException;
import net.zx.pojo.FakeUser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class UserManagerTester {
	public static UserManager manager;
	
	@Rule
	public TestRule myrule = new TestRule() {
		
		public Statement apply(final Statement base, final Description description) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable{
					try {
						System.out.println("rule before ");
						base.evaluate();	
						System.out.println("rule after ");
					} catch (Throwable t) {
						System.out.println("faild: " + description.getMethodName());
						throw t;
					}
				}
			};
		}
	};
	
	@BeforeClass
	public static void setupClass() {
		System.out.println("before class");
		manager = new UserManager();
	}
	@AfterClass
	public static void tearDownClass() {
		System.out.println("after class");
	}
	@Before
	public void setup() {
		System.out.println("before method");
	}
	@After
	public void teardown() {
		System.out.println("After method");
	}
	
	@Test
	public void addUserTester() {
		System.out.println("addUser testing");
		FakeUser user = manager.addUser();
		Assert.assertEquals("admin10", user.getUserName());
	}
	
	@Test
	public void getUserTester() {
		System.out.println("getUser testing");
		FakeUser user = manager.getUser(8);
		Assert.assertEquals("getUser testing", "admin8", user.getUserName());
		Assert.assertEquals(8, user.getId());
	}
	
	@Test(expected = BusinessException.class )
	public void deleteUser() throws Exception{
		manager.deleteUser();	
	}

	@Ignore("ignore this test case")
	@Test
	public void ingoredTester() {
		System.out.println("ignore testing");
	}
}
