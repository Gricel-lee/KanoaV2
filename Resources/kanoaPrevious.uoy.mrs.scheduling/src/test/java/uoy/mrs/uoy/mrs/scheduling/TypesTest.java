package uoy.mrs.uoy.mrs.scheduling;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.*;

import uoy.mrs.uoy.mrs.RunApp;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.types.LocationImpl;
import uoy.mrs.uoy.mrs.types.RobotImpl;

public class TypesTest {
	
	//Files
	static String dummyFilesPath = System.getProperty("user.dir") + "/src/test/java/dummy/src-gen";
	static String infoDSL = dummyFilesPath + "/infoDSL.txt";
	static String modelAllocation = dummyFilesPath + "/modelAllocation.als";
	static String modelMissionsTree = dummyFilesPath + "/modelMissionsTree.txt";
	static String worldmodel = dummyFilesPath + "/worldmodel.txt";
	
	
	static String locID = "l1";
	static LocationImpl loc;
	
	static RunApp mrs;
	
	@BeforeClass
	public static void setupClass() throws Exception {
		
		mrs = new RunApp();
		
		System.out.println(Constants.filespath+"jj");
		
		loc = new LocationImpl(locID,"4.0","5.0");
		RobotImpl robot = new RobotImpl("r1",loc,"{}");  
	}
	
	
	@Test
	public void configProp() {
		try {
			Constants.setProperties("src/test/java/dummyFiles/config.properties");
			assertEquals("configProp",Constants.filespath, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void locTest() {
		String expected = locID;
		String actual = loc.getID();
		assertEquals("Testing location id",expected, actual);
		
	}
	
	//Test location

	@After
    public void afterEachTest() {
		System.out.println(new File("src/test/java/dummyFiles/config.properties").getParentFile());
        System.out.println("Test Completed");
    }
	
	
	
	public static void robotTest(){
		System.out.println("2");
		//robot.getID());
		
	}
}
