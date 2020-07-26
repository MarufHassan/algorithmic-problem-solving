# [729. My Calendar I][title]

## Problem Description

Detail instruction can be found [here][title].

**Example:**

```
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true

Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
```

## Solution

**Approach 1: Brute Force**

```java
class MyCalendar {
    private List<Event> events;
    
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (Event e : events) {
            if (start < e.end && end > e.start)
                return false;
            /* alternative
            if (Math.max(start, e.start) < Math.min(end, e.end))
                return false;
            */
        }
        events.add(new Event(start, end));
        return true;
    }
}
```

**private helper class**

```java
class Event {
    int start, end;
    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
```

## Test

Compile with `javac MyCalendar.java` and run with `java -ea MyCalendar`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/my-calendar-i/