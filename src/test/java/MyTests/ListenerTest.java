package MyTests;

import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners(MyTests.MyListener.class)
public class ListenerTest {
	
	@Test(priority=1)
	public void test1() {
		Assert.assertEquals("A", "A");
	}
	
	@Test(priority=2)
	public void test2() {
		Assert.assertEquals("A", "B");
	}
	
	@Test(priority=3, dependsOnMethods = {"test2"})
	public void test3() {
		Assert.assertEquals("A", "A");
	}

	


}
