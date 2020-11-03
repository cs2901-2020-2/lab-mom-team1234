package lab;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    static final Logger logger = Logger.getLogger(Receiver.class.getName());
    private CountDownLatch latch = new CountDownLatch(5);

    public void receiveMessage(String message) {
        message = "Received: " + message;
        logger.info(message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
