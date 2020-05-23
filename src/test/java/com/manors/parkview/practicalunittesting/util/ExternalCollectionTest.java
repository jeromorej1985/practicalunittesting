package com.manors.parkview.practicalunittesting.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import com.manors.parkview.practicalunittesting.model.Book;

import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;


public class ExternalCollectionTest {
    private Set<String> setA;
    private Set<String> setB;
    private String string1;
    private String string2;

    @Before
    public void setup(){
        setA = new LinkedHashSet<>();
        setB = new LinkedHashSet<>();
        string1 = "This is string1 content";
        string2 = "This is string2 content";

        setA.add(string1);
        setA.add(string2);
        setB.add(string2);
        setB.add(string1);
    }

    @Test
    public void twoSetsAreEqualsIfTheyHaveSameContentAndSameOrder(){
        assertReflectionEquals(setA, setB);
    }

    @Test
    public void twoSetsAreEqualsIfTheyHaveSameContentAndAnyOrder(){
        assertReflectionEquals(setA, setB, ReflectionComparatorMode.LENIENT_ORDER);
    }

    @Test
    public void twoSetsAreEqualsIfTheyHaveSameContentAnyOrderFestStyle() throws Exception {
        assertThat(setA).isNotEmpty()
            .hasSize(2).doesNotHaveDuplicates();
        assertThat(setA).containsOnly(string1, string2);
    }

    @Test
    public void testMapUtilityMethods() throws Exception {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 2);
        map.put("b", 3);

        assertThat(map).isNotNull().isNotEmpty()
            .includes(entry("a", 2), entry("b", 3))
            .excludes(entry("c", 2));
    }

    @Test
    public void testMapUtilityHamcrestStyle() throws Exception {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 2);
        map.put("b", 3);

        org.hamcrest.MatcherAssert.assertThat(map, org.hamcrest.collection.IsMapContaining.hasEntry("a", (Object) 2));
        org.hamcrest.MatcherAssert.assertThat(map, org.hamcrest.collection.IsMapContaining.hasKey("b"));

    }

    @Test
    public void lookingIntoPropertiesFESTStyle() throws Exception {
        Collection<Book> books = new HashSet<>();
        Book book = new Book("Odyssey"); 
        book.setAuthor("Homer");
        books.add(book);
        books.add(new Book("Hobbit"));
        books.add(new Book("Javascript The Definitive Guide"));
        books.add(new Book("SQL in a Nutshell"));

        assertThat(books).isNotNull().isNotEmpty();
        assertThat(books).onProperty("title").contains("Hobbit");
        assertThat(books).onProperty("title").contains("Javascript The Definitive Guide");
        assertThat(books).onProperty("author").contains("Homer");
    }
}