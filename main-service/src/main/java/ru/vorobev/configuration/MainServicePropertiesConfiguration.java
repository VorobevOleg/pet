package ru.vorobev.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:mainServiceConnections.yaml", factory = YamlPropertySourceFactory.class)
public class MainServicePropertiesConfiguration {
}
