import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import lab.SuscriberApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
class ReceiverTests {
    @Test
    void mainTest() {
        SuscriberApp.main(new String[]{});
        Assert.assertTrue(true, "MakeTest");
    }
}
