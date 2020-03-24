package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import annotation.TestExample;
import annotation.test.TestClass.Test;
import annotation.test.TestInformation;

public class RunTests {

  public static void main(String[] args) throws Exception {

	System.out.println("Testing...");

	int passed = 0, failed = 0, count = 0, ignore = 0;

	Class<TestExample> obj = TestExample.class;

	// Process @TestInformation
	if (obj.isAnnotationPresent(TestInformation.class)) {

		Annotation annotation = obj.getAnnotation(TestInformation.class);
		TestInformation testInformation = (TestInformation) annotation;

		System.out.printf("%nPriority :%s", testInformation.priority());
		System.out.printf("%nCreatedBy :%s", testInformation.createdBy());
		System.out.printf("%nTags :");

		int tagLength = testInformation.tags().length;
		for (String tag : testInformation.tags()) {
			if (tagLength > 1) {
				System.out.print(tag + ", ");
			} else {
				System.out.print(tag);
			}
			tagLength--;
		}

		System.out.printf("%nLastModified :%s%n%n", testInformation.lastModified());
	}

	// Process @Test
	for (Method method : obj.getDeclaredMethods()) {

		// if method is annotated with @Test
		if (method.isAnnotationPresent(Test.class)) {

			Annotation annotation = method.getAnnotation(Test.class);
			Test test = (Test) annotation;

			// if enabled = true (default)
			if (test.enabled()) {

			  try {
				method.invoke(obj.newInstance());
				System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
				passed++;
			  } catch (Throwable ex) {
				System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
				failed++;
			  }

			} else {
				System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
				ignore++;
			}
		}
	}
	
	System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);
	}
}