package com.manors.parkview.practicalunittesting.driver;

import static com.manors.parkview.practicalunittesting.util.BookAssert.assertThat;

import com.manors.parkview.practicalunittesting.model.Book;

import org.junit.Test;

public class BookFestTest {

    private static final String TITLE = "My book";

    @Test
    public void constructorShouldSetTitle(){
        Book book = new Book(TITLE);

        assertThat(book).hasTitle(TITLE);
    }
    
}