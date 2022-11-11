package by.pizzadog.service;

import by.pizzadog.model.HttpPhoneRequest;
import by.pizzadog.model.PhoneNumberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpPhoneServiceImpl implements HttpPhoneService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpPhoneRequest<HttpHeaders> phoneRequest;

    @Value("${kufar.url.phone}")
    String URL;

    @Override
    public PhoneNumberDto getPhone() {
        return new PhoneNumberDto("375112223344");
    }

    @Override
    public PhoneNumberDto getPhoneById(Long id) {
        String caseUrl = URL + id + "/phone";
        return restTemplate.exchange(caseUrl, HttpMethod.GET, phoneRequest, PhoneNumberDto.class).getBody();
    }
}
