import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import lab.SuscriberApp;
import org.testng.Assert;

@SpringBootTest
class receiverTests {
    @Test
    void contextLoads() {
    }
    @org.testng.annotations.Test(invocationCount = 16, threadPoolSize = 16)
    void maintest() {
        SuscriberApp.main(new String[]{});
        Assert.assertTrue(true,"MakeTest");
    }
}
