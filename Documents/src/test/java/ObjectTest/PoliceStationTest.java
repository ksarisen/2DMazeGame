package ObjectTest;

import Objects.PoliceStation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PoliceStationTest {
    private PoliceStation b;

    @BeforeEach
    void setup() {
        b = new PoliceStation("l");
    }

    @Test
    void generateRightPoliceStation() {
        b = new PoliceStation("r");
        assertNotNull(b, "fail to create right police station");
    }

    @Test
    void generateLeftPoliceStation() {
        assertNotNull(b, "fail to create left police station");
    }
}
