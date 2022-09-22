package by.pizzadog.service;

import by.pizzadog.model.PhoneNumberDto;

public interface HttpPhoneService {

    PhoneNumberDto getPhone();

    PhoneNumberDto getPhoneById(Long id);
}
