package by.pizzadog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${token.default}")
    private String token;

    @Autowired
    HttpHeaders httpHeaders;

    @Override
    public String getCurrentToken() {
        return token;
    }

    @Override
    public String setCurrentToken(String token) {
        this.token = token;
        httpHeaders.set("authorization", token);
        return token;
    }

    @Override
    public LocalDate getTokenExpiration() {
        return null;
    }
}
