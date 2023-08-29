package com.systechafrica.looping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoopingStatementsTest {
    LoopingStatements app = new LoopingStatements();

    @Test
    public void number_in_range_to_fifty(){
        int search_number=10;
        int searched = app.search(search_number);
        Assertions.assertEquals(search_number,searched,"The searced integer should be"+searched);
    }
}
