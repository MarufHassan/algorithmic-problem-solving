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

class Event {
    int start, end;
    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
}