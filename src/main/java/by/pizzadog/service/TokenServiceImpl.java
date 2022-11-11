package by.pizzadog.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Base64;
import java.util.TimeZone;

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
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = token.split("\\.");
        String payload = new String(decoder.decode(chunks[1]));
        JSONObject json = new JSONObject(payload);
        long exp = json.getLong("exp");
        return LocalDate.ofInstant(Instant.ofEpochSecond(exp), TimeZone.getDefault().toZoneId());
    }
}
