package by.pizzadog.controller;

import by.pizzadog.model.TokenDto;
import by.pizzadog.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/token")
    public String getCurrentToken() {
        return tokenService.getCurrentToken();
    }

    @PostMapping("/token")
    public String setCurrentToken(@RequestBody TokenDto tokenDto) {
        return tokenService.setCurrentToken(tokenDto.getToken());
    }
}
