package ObjectTest;

import Objects.BarrierGrass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BarrierGrassTest {
    private BarrierGrass g;
    @BeforeEach
    void setup()
    {
        g=new BarrierGrass(" ");
    }

    @Test
    void generateBarrierGrass()
    {
        assertNotNull(g,"fail to create barrier grass");
    }
}
