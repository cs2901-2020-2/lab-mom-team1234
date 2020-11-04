package lab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReceiverContainer {
    List<Receiver> receiverList = new ArrayList<Receiver>();

    public ReceiverContainer () {
        for (int i = 0; i < 50; i++)
            receiverList.add(new Receiver());
    }

    public void receiveMessage (String message) {
        for (int i = 0; i < receiverList.size(); i++)
            receiverList.get(i).receiveMessage(message);
    }
}
