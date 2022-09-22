package by.pizzadog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class HealthCheckControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void healthCheckTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/health")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        assertEquals("I'm alive", response);
    }
}
