package ru.vorobev.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:externalServiceConnections.yaml", factory = YamlPropertySourceFactory.class)
public class ExternalApiServicePropertiesConfiguration {
}
