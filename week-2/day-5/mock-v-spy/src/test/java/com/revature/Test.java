package com.revature;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class Test {

    @org.junit.jupiter.api.Test
    public void demo() {
        List<Object> myList = mock(List.class); // Here we have a mock List
        System.out.println(myList.get(1)); // null, because we have default return values

        when(myList.get(eq(1))).thenReturn(new Object());
        System.out.println(myList.get(1));

        // The above example is a mock, which is a completely fake object
        // Notice that we are even just using the List interface and mocking that interface,
        // We aren't even mocking a class with actual implemented methods (because we don't need to)
        // Mocks don't care about the code you have for any particular class


        // On the other hand, Spies are what you would call "partial-mocks"
        // They are real objects that rely on actual code
        List<Object> myList2 = spy(ArrayList.class);

        myList2.add(new Object());
        System.out.println(myList2.size()); // 1

        // partial-mock
        when(myList2.get(eq(100))).thenReturn(new Object());
        System.out.println(myList2.get(100));

        // A spy is a mixture of both fake and real

        // You can use verify on both mocks and spies to check how many times these
        // methods were actually invoked
        // This is useful when testing the service layer to ensure that your service method
        // is invoking the dao method X number of times (or never)
        verify(myList2, times(1)).get(anyInt());
    }

}
