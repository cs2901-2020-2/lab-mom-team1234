package publisher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.testng.Assert;

import org.springframework.amqp.core.Queue;
import org.testng.annotations.Test;

@Test
class MessagingRabbitmqApplicationTest {

    Queue initialQueue = new Queue("spring-boot", false);

    @Test
    void queue() {
        MessagingRabbitmqApplication messagingRabbitmqApplication = new MessagingRabbitmqApplication();
        Queue toCompare = messagingRabbitmqApplication.queue();
        Assert.assertEquals(initialQueue.getName(), toCompare.getName());
        Assert.assertEquals(initialQueue.isDurable(), toCompare.isDurable());
    }

    TopicExchange initialExchange = new TopicExchange("spring-boot-exchange");

    @Test
    void exchange() {
        MessagingRabbitmqApplication messagingRabbitmqApplication = new MessagingRabbitmqApplication();
        TopicExchange toCompare = messagingRabbitmqApplication.exchange();
        Assert.assertEquals(initialExchange.getName(), toCompare.getName());
    }

    @Test
    void binding() {
        MessagingRabbitmqApplication messagingRabbitmqApplication = new MessagingRabbitmqApplication();
        Binding initial = BindingBuilder.bind(initialQueue).to(initialExchange).with("foo.bar.#");
        Binding toCompare = messagingRabbitmqApplication.binding(initialQueue, initialExchange);
        Assert.assertEquals(initial.getExchange(), toCompare.getExchange());
        Assert.assertEquals(initial.getRoutingKey(), toCompare.getRoutingKey());
    }
}