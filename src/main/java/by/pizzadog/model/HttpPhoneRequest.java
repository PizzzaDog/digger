package by.pizzadog.model;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;


public class HttpPhoneRequest<T> extends HttpEntity<T> {

    public HttpPhoneRequest(MultiValueMap<String, String> headers) {
        super(headers);
    }
}
