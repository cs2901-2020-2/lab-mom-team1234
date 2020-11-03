package publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class Runner implements CommandLineRunner {
    static final Logger logger = Logger.getLogger(Runner.class.getName());
    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        logger.info("Sending message...");
        rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.TOPIC_EXCHANGE_NAME, "foo.bar.baz", "Hello from Jonathan!");
        rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.TOPIC_EXCHANGE_NAME, "foo.bar.baz", "Hello from Jonathan2!");
    }

}
