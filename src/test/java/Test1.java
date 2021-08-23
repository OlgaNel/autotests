import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

    private FirstTest firstTest;
    User anton;

    @BeforeClass
    public void setupUser(){
        System.out.println("Setup test env");
        anton = new User("Anton", 30, false);
        firstTest = new FirstTest();
    }
    @AfterTest
    public void cleanUp(){
        System.out.println("Cleared data");
        anton = null;
    }

    @org.testng.annotations.Test
    public void testSumm(){
        Assert.assertEquals(firstTest.summ(2, 3), 4, errorMeesage());
    }

    @org.testng.annotations.Test
    public void testUserName(){
        //Assert.assertTrue(!anton.getRegistared(), "User not registered");
        Assert.assertEquals(anton.getName(), "Anton", errorMeesage());
    }

    @org.testng.annotations.Test
    public void testUserAge(){
        Assert.assertEquals(anton.getAge(), 30, errorMeesage());
    }

    private String errorMeesage(){
        return "Something wrong with test data";
    }
}
