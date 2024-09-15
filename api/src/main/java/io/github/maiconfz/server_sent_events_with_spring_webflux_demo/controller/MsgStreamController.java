
package io.github.maiconfz.server_sent_events_with_spring_webflux_demo.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.maiconfz.server_sent_events_with_spring_webflux_demo.model.Msg;
import reactor.core.publisher.Flux;

@RestController
public class MsgStreamController {

    @GetMapping("/msg-stream")
    public Flux<ServerSentEvent<Msg>> msgStream() {
        Flux<ServerSentEvent<Msg>> eventFlux = Flux
                .interval(Duration.ofMillis(500))
                .map(sequence -> ServerSentEvent.<Msg>builder()
                        .id(String.valueOf(sequence))
                        .event("message")
                        .data(new Msg("Msg " + UUID.randomUUID().toString(), LocalDateTime.now()))
                        .build());

        return eventFlux;
    }

}
