package me.arunav.spring.matchers;

import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class MatchersExploration {

    @Test
    @DisplayName("Exploring some Hamcrest Matchers")
    public void explore_someHamcrestMatchers() {

        List<Integer> items = Arrays.asList(23, 87, 64);

        MatcherAssert.assertThat(items, hasSize(3));
        MatcherAssert.assertThat(items, hasItems(87, 23));
        MatcherAssert.assertThat(items, everyItem(greaterThan(20)));
        MatcherAssert.assertThat(items, everyItem(lessThan(90)));

        MatcherAssert.assertThat("", blankOrNullString());
        MatcherAssert.assertThat("ABCDE", startsWith("AB"));
        MatcherAssert.assertThat("ABCDE", containsString("CD"));
        MatcherAssert.assertThat("ABCDE", endsWith("CDE"));

    }

    @Test
    @DisplayName("Exploring some AssertJ Matchers")
    public void explore_someAssertJMatchers() {

        List<Integer> items = Arrays.asList(23, 87, 64);

        Assertions.assertThat(items)
                .hasSize(3)
                .contains(64)
                .allMatch(item -> item > 20)
                .allMatch(item -> item < 100)
                .anyMatch(item -> item > 50)
                .noneMatch(item -> item < 5);

        Assertions.assertThat("").isEmpty();

        Assertions.assertThat("ABCDE")
                .startsWith("ABC")
                .contains("CD")
                .endsWith("DE");

    }
}
