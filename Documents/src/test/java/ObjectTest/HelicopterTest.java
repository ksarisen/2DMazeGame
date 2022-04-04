package ObjectTest;

import Objects.PoliceStation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelicopterTest {
    private PoliceStation p;
    @BeforeEach
    void setup() {
        p = new PoliceStation(" ");
    }

    @Test
    void generateRightPoliceStation() {
        assertNotNull(p, "fail to create the helicopter");
    }
}
