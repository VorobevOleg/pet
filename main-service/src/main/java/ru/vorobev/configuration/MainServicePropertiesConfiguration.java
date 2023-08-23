package ru.vorobev.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:mainConnections.yaml", factory = YamlPropertySourceFactory.class)
public class MainServicePropertiesConfiguration {
}
