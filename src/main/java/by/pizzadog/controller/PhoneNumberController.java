package by.pizzadog.controller;

import by.pizzadog.model.PhoneNumberDto;
import by.pizzadog.service.HttpPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {

    @Autowired
    private HttpPhoneService phoneService;

    @GetMapping("/phone/{id}")
    public PhoneNumberDto getById(@PathVariable Long id) {
        return phoneService.getPhoneById(id);
    }
}
