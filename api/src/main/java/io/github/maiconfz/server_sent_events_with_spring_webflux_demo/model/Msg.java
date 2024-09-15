package io.github.maiconfz.server_sent_events_with_spring_webflux_demo.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Msg {
    private final String msg;
    private final LocalDateTime date;
}
