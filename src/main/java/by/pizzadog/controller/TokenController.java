package by.pizzadog.controller;

import by.pizzadog.model.TokenDto;
import by.pizzadog.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/token")
    public TokenDto getCurrentToken() {
        return new TokenDto(tokenService.getCurrentToken());
    }

    @PostMapping("/token")
    public TokenDto setCurrentToken(@RequestBody TokenDto tokenDto) {
        return new TokenDto(tokenService.setCurrentToken(tokenDto.getToken()));
    }

    @GetMapping("/token/exp")
    public LocalDate getExpiration() {
        return tokenService.getTokenExpiration();
    }
}
