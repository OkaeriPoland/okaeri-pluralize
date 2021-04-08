package eu.okaeri.pluralizetest;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static eu.okaeri.pluralize.Pluralize.pluralize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPluralize {

    private static final Locale POLISH = Locale.forLanguageTag("pl");
    private static final Locale ENGLISH = Locale.forLanguageTag("en");

    @Test
    public void test_pluralize_pl() {
        assertEquals("psów", pluralize(POLISH, -1, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 0, "pies", "psy", "psów"));
        assertEquals("pies", pluralize(POLISH, 1, "pies", "psy", "psów"));
        assertEquals("psy", pluralize(POLISH, 2, "pies", "psy", "psów"));
        assertEquals("psy", pluralize(POLISH, 3, "pies", "psy", "psów"));
        assertEquals("psy", pluralize(POLISH, 4, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 5, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 6, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 7, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 8, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 9, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 10, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 11, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 12, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 13, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 14, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 15, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 16, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 17, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 18, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 19, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 20, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 21, "pies", "psy", "psów"));
        assertEquals("psy", pluralize(POLISH, 22, "pies", "psy", "psów"));
        assertEquals("psy", pluralize(POLISH, 23, "pies", "psy", "psów"));
        assertEquals("psy", pluralize(POLISH, 24, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 25, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 26, "pies", "psy", "psów"));
        assertEquals("psów", pluralize(POLISH, 27, "pies", "psy", "psów"));
    }

    @Test
    public void test_pluralize_en() {
        assertEquals("apples", pluralize(ENGLISH, -1, "apple", "apples"));
        assertEquals("apples", pluralize(ENGLISH, 0, "apple", "apples"));
        assertEquals("apple", pluralize(ENGLISH, 1, "apple", "apples"));
        assertEquals("apples", pluralize(ENGLISH, 2, "apple", "apples"));
        assertEquals("apples", pluralize(ENGLISH, 3, "apple", "apples"));
    }
}
