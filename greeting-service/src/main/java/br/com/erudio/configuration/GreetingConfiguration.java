package br.com.erudio.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("greeting-service")
@NoArgsConstructor
@Getter
@Setter
public class GreetingConfiguration {

    private String greeting;
    private String defaultValue;
}
