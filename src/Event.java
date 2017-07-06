public class Event implements Comparable<Event> {
    private EventCategory category;
    private String title;

    public Event(String title, EventCategory category) throws NullPointerException, IllegalArgumentException{
        if(title == null || category == null) throw new NullPointerException();
        if(title == "") throw new IllegalArgumentException();
        this.category = category;
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    public EventCategory getCategory() {
        return category;
    }

    public int compareTo(Event e) {
        if(!e.getTitle().equals(this.getTitle())) {
            return this.getTitle().compareTo(e.getTitle());
        } else if (!e.getCategory().equals(this.getCategory())) {
               return this.getCategory().compareTo(e.getCategory());
        } else return 0;

    }
}
