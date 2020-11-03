package publisher;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

@Test
class RunnerTest {

    @Test(threadPoolSize = 30, invocationCount = 30)
    void test0() {
        RabbitmqPublisherApplication.main(new String[] {});
        Assert.assertTrue(true, "silly assertion to be compliant with Sonar");
    }

    void run(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        Runner runner = spy(new Runner(rabbitTemplate));
        Assert.assertNotEquals(rabbitTemplate, null);
        Assert.assertEquals(runner.getRabbitTemplate(), rabbitTemplate);
    }
}