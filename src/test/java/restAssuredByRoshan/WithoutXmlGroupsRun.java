package restAssuredByRoshan;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import day3RestAssured.Headers;

public class WithoutXmlGroupsRun {

	public static void main(String[] args) {
		
		TestNG test=new TestNG();
		test.setTestClasses(new Class[] {
				AgilePostRequest.class , 	Headers.class
		});
		test.setGroups("smoke");
		test.setParallel(XmlSuite.ParallelMode.TESTS);
		test.run();
		
	}
}
