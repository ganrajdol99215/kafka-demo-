@RestController
public class EventController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/trigger")
    public void triggerEvent() {
        kafkaTemplate.send("demo-topic", "EVENT_TRIGGERED");
    }
}
