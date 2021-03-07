package parser;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.Assert;

import org.hamcrest.collection.IsMapContaining;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.*;

public class PageTest {

    @Test
    public void testSplitPage() {
        String initialText = "Services include art direction, UX & UI design; design systems.";

        Delimiters delimiters = new Delimiters(",");
        String[] expected = {"Services include art direction", " UX & UI design; design systems."};
        Assert.assertArrayEquals(expected, delimiters.splitPage(initialText));

        delimiters.setDelimiters(",;.");
        expected = new String[]{"Services include art direction", " UX & UI design", " design systems"};
        Assert.assertArrayEquals(expected, delimiters.splitPage(initialText));

        delimiters.setDelimiters("\s");
        expected = new String[]{"Services", "include", "art", "direction,", "UX", "&", "UI", "design;",
                "design", "systems."};
        Assert.assertArrayEquals(expected, delimiters.splitPage(initialText));
    }

    @Test
    public void testCountWords() {
        String[] words = {"Мы", "мы", "МЫ", "мЫ", "предлагаем", "услуги", "по", "услуги"};
        Map<String, Integer> expected = Map.of(
                "мы", 4,
                "по", 1,
                "предлагаем", 1,
                "услуги", 2
        );
        Map<String, Integer> res = Page.countWords(words);

        // size
        assertThat(res.size(), is(4));
        // entry
        assertThat(res, IsMapContaining.hasEntry("мы", 4));
        // key
        assertThat(res, IsMapContaining.hasKey("по"));
        // value
        assertThat(res, IsMapContaining.hasValue(2));
        // equality
        assertThat(res, is(expected));
    }
}
