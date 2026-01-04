@Component
public class EventConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void listen(String message) {
        System.out.println("Received from Kafka: " + message);

        // Send to UI via WebSocket
        messagingTemplate.convertAndSend("/topic/events", message);
    }
}
