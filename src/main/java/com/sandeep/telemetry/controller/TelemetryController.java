package com.sandeep.telemetry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TelemetryController {

    private final MeterRegistry meterRegistry;

    public TelemetryController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/api/telemetry")
    public String telemetry() {
        meterRegistry.counter("custom_telemetry_counter").increment();
        return "Telemetry event recorded!";
    }
}