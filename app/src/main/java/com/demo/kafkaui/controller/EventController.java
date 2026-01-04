import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;

@RestController
public class EventController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/trigger")
    public void triggerEvent() {
        kafkaTemplate.send("demo-topic", "EVENT_TRIGGERED");
    }
}
