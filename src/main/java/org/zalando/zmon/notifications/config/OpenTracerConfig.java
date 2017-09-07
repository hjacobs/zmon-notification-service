package org.zalando.zmon.notifications.config;

import io.opentracing.Tracer;

public interface OpenTracerConfig {
    public Tracer generateTracer();
}