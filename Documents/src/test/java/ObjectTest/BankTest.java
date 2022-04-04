package ObjectTest;

import Objects.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank b;
    @BeforeEach
    void setup()
    {
        b=new Bank("l");
    }

    @Test
    void generateRightBank()
    {
        b=new Bank("r");
        assertNotNull(b,"fail to create right bank");
    }

    @Test
    void generateLeftBank()
    {
        assertNotNull(b,"fail to create left bank");
    }
}
