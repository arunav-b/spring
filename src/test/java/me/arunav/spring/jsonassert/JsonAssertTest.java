package me.arunav.spring.jsonassert;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actual = "{\"id\":1,\"name\":\"Item 1\",\"price\":10.5,\"quantity\":50}";

    @Test
    @DisplayName("All attributes should match between actual and expected json")
    public void test_strictTrue() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Item 1\",\"price\":10.5,\"quantity\":    50}";
        JSONAssert.assertEquals(expected, actual, true);
    }

    @Test
    @DisplayName("Atleast expected attributes should match with actual")
    public void test_strictFalse() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Item 1\",\"price\":10.5}";
        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    @DisplayName("Validate attributes without quotes")
    public void test_withoutQuotes() throws JSONException {
        String expected = "{id:1,name:\"Item 1\",price:10.5}";
        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    @DisplayName("Validate attributes without quotes")
    public void test_withoutQuotesButStrict() throws JSONException {
        String expected = "{id:1,name:\"Item 1\",price:10.5, quantity: 50}";
        JSONAssert.assertEquals(expected, actual, false);
    }
}
