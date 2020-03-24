package annotation;

import annotation.test.TestClass.Test;
import annotation.test.TestInformation;
import annotation.test.TestInformation.Priority;

@TestInformation(
	priority = Priority.HIGH, 
	createdBy = "mkyong.com",  
	tags = {"sales","test" }
)
public class TestExample {

	@Test
	void testFirst() {
	  if (true)
		throw new RuntimeException("This test always failed");
	}

	@Test(enabled = false)
	void testSecond() {
	  if (false)
		throw new RuntimeException("This test always passed");
	}

	@Test(enabled = true)
	void testThird() {
	  if (10 > 1) {
		// this test always passed.
	  }
	}
}