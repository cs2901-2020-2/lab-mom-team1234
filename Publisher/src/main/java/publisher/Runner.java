package publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class Runner implements CommandLineRunner {
    static final Logger logger = Logger.getLogger(Runner.class.getName());
    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Sending message...");
        LocalDateTime startTime = LocalDateTime.now();
        while (LocalDateTime.now().getSecond () - startTime.getSecond() < 60) {
            TimeUnit.MILLISECONDS.sleep (100);
            rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.TOPIC_EXCHANGE_NAME, "foo.bar.baz", "Hello from Jonathan!: " + LocalDateTime.now());
        }
    }

}
