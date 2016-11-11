import exam.files.football.FootballData;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FootballDataTest {
    
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
    public void testTeamWithSmallestGoalDifference() throws IOException{
        FootballData fData = new FootballData("football.dat");
        fData.init();
        String team = fData.findSmallestGoalDifferenceTeam();
        assertTrue(team.equals("Aston_Villa"));
    }
    
}
