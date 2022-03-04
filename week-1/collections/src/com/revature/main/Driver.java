package com.revature.main;

import java.util.*;

public class Driver {

    public static void main(String[] args) {
        listDemo();
        queueDemo();
        setDemo();
        mapDemo();

        // Problem: Given a list, determine if there are any duplicates in the List

        // Solution O(n)
        // 1. Iterate over the List, and add elements from list to Set O(n)
        // 2. compare the number of elements in the Set v. number of elements in the List O(1)
        // 3. If the # in the Set == # in the List, there are no duplicates
        // 4. If it's different, you know there were duplicates in the List

        // Solution O(n log n)
        // 1. Sort the List O(n log n)
        // 2. Iterate through the list and check if the next element is the same as the previous element O(n)
        // 3. If you find such a case, then you have a duplicate element
    }

    public static void mapDemo() {
        Map<String, Long> phoneNumbers = new HashMap<>();

        phoneNumbers.put("Mom", 5120000000L);
        phoneNumbers.put("Dad", 5120000001L);
        phoneNumbers.put("Sister", 5120000002L);

        System.out.println(phoneNumbers.get("Mom")); // O(1)
        System.out.println(phoneNumbers.get("Dad")); // O(1)
        System.out.println(phoneNumbers.get("Sister")); // O(1)

        // Map is not an Iterable, so you cannot use a for each loop

        // Iterating over key-value pairs in a map
        // entrySet returns a Set that contains Map.Entry objects which in turn contain the key
        // and value
        Set<Map.Entry<String, Long>> keyValuePairs = phoneNumbers.entrySet();
        for (Map.Entry<String, Long> pair : keyValuePairs) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        // Iterate over just the keys
        Set<String> keys = phoneNumbers.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + phoneNumbers.get(key));
        }

        // Iterate over just the values
        Collection<Long> values = phoneNumbers.values();
        for (Long value : values) {
            System.out.println(value);
        }

    }

    public static void setDemo() {
        Set<String> mySet = new HashSet<>();

        mySet.add("hello");
        mySet.add("greetings");
        mySet.add("hello");
        mySet.add("hi");
        mySet.add("bonjour");
        mySet.add("hola");

        // There is no ordering based on when you added an element to the Set, whenever
        // you're iterating over the set using a for-each loop
        // O(n)
        for (String s : mySet) {
            System.out.println(s);
        }

        // contains O(1)
        System.out.println("mySet contains 'hello': " + mySet.contains("hello"));
    }

    public static void queueDemo() {
        Queue<String> myQueue = new LinkedList<>();

        myQueue.offer("Person 1");
        myQueue.offer("Person 2");

        // This is a little bit of cheating (based on some people's opinions)
        // since you're able to peek at every single element inside of the queue
        // Ideally, you should only be able to see the element at the front of the queue
        for (String s : myQueue) {
            System.out.println(s);
        }

        System.out.println(myQueue.poll()); // Person 1

        myQueue.offer("Person 3");

        System.out.println("Peeking at the front of the queue: " + myQueue.peek());

        System.out.println(myQueue.poll()); // Person 2
        System.out.println(myQueue.poll()); // Person 3
    }

    public static void listDemo() {
        List<Integer> myInts = new ArrayList<>();

        myInts.add(1);
        myInts.add(10);
        myInts.add(-100);
        myInts.add(-50);
        myInts.add(1);
        myInts.add(10);
        myInts.add(-100);
        myInts.add(-50);

        // Regular for loop
        for (int i = 0; i < myInts.size(); i++) {
            System.out.println(myInts.get(i));
        }

        // for-each (which is possible because Lists are Iterables (Iterable interface))
        for (int i : myInts) {
            System.out.println(i);
        }

        Iterable<Integer> myIterable = myInts;
        for (int i : myIterable) {
            System.out.println(i);
        }

        myInts.remove(0); // O(n)
        // Behind the scenes, an ArrayList needs to shift all the elements on the right
        // to the left

        myInts.remove(3); // middle O(n/2) = O(n)

        myInts.add(3, 10000); // Overloaded method
        // O(n) <- need to shift elements after the index you would like to add to to the right

        // O(n log n)
        Collections.sort(myInts); // Sort the List "in-place"

        System.out.println(myInts);
    }

}
