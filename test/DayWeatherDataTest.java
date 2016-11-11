import exam.files.days.DayWeatherData;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DayWeatherDataTest {
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testDayWithSmallestTempDifference() throws IOException{
        DayWeatherData data = new DayWeatherData("weather.dat");
        data.init();
        int dayNumber = data.findSmallestTempDifferenceDay();
        assertTrue(dayNumber == 14);
    }
}
