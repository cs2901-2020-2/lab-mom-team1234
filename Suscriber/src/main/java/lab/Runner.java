package lab;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private List<Receiver> receivers;

    public Runner() {
        receivers = new ArrayList<Receiver>();
        for (int i = 0; i < 50; i++)
            receivers.add(new Receiver());
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < receivers.size(); i++)
            receivers.get(i).getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}
