package me.arunav.spring;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@Sql({"/schema.sql", "/data.sql"})
class SpringBasicsApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Checking if all items are fetched from the DB")
    void test_getItemsApi() throws JSONException {
        String response = restTemplate.getForObject("/items", String.class);
        JSONAssert.assertEquals("[{id:101}, {id:102}, {id:103}]", response, false);
    }

}
