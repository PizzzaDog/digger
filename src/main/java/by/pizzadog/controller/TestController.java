package by.pizzadog.controller;

import by.pizzadog.model.PhoneNumberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/phone")
    public PhoneNumberDto getPhone() {
        PhoneNumberDto dto = new PhoneNumberDto();
        dto.setPhone("37544632234");
        return dto;
    }
}
