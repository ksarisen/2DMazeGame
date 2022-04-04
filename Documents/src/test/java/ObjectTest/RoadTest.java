package ObjectTest;
import Objects.Road;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class RoadTest {
    @Test
    void generateTwoDirectionsRoad()
    {
        Road r= new Road("sw");
        assertNotNull(r,"Fail to create the Road with 2 directions");
    }
    @Test
    void generateThreeDirectionsRoad()
    {
        Road r= new Road("new");
        assertNotNull(r,"Fail to create the Road with 3 directions");
    }
    @Test
    void generateFourDirectionsRoad()
    {
        Road r= new Road("o");
        assertNotNull(r,"Fail to create the Road with 4 directions");
    }

}
