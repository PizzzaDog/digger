package by.pizzadog.config;

import by.pizzadog.model.HttpPhoneRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    @Value("${variable.bel.ip}")
    private String BEL_IP;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpPhoneRequest<HttpHeaders> getCommonHttpRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
        headers.add("content-type", "application/json");
        headers.add("X-Forwarded-For", BEL_IP);
        return new HttpPhoneRequest<>(headers);
    }
}
