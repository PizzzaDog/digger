package by.pizzadog.service;

import java.time.LocalDate;

public interface TokenService {

    String getCurrentToken();

    String setCurrentToken(String token);

    LocalDate getTokenExpiration();
}
