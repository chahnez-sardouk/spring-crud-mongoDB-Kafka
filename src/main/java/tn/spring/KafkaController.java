package tn.spring;


import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        kafkaProducer.sendMessage(message);
        return "Message sent: " + message;
    }
}