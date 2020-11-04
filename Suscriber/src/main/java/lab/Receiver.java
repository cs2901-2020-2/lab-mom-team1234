package lab;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    public static int idCount = 0;
    private int id;
    static final Logger logger = Logger.getLogger(Receiver.class.getName());
    private CountDownLatch latch = new CountDownLatch(5);

    public Receiver () {
        id = Receiver.idCount++;
        logger.info("Created receiver with id: " + Integer.toString(id));
    }

    public void receiveMessage(String message) {
        message = "Received: " + message + " id : " + Integer.toString(id);
        logger.info(message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
