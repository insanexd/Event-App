import java.util.*;
import java.util.TreeMap;

public class EventCatalogImpl implements EventCatalog {
    //Attributes
    private TreeMap<Event,Set<Time>> myMap = new TreeMap<>();

    //Operations
    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) throws NullPointerException {
        if(e == null) throw new NullPointerException();
        for(Time t : tSet) {
            if(t == null) throw new NullPointerException();
        }
        if(myMap.containsKey(e)) {
            return false;
        }

        myMap.put(e, tSet);
        return true;
    }
    @Override
    public boolean addTimeToEvent(Event e, Time t) throws NullPointerException {
        if(e == null || t == null) throw new NullPointerException();
        if(!myMap.containsKey(e)) {
            return false;
        }
        if(myMap.get(e).contains(t)) {
            return false;
        }
        myMap.get(e).add(t);
        return true;
    }
    @Override
    public Set<Event> getAllEvents() {
        Set<Event> eventSet = new HashSet<Event>();
        for(Map.Entry<Event, Set<Time>> entry : myMap.entrySet()) {
            eventSet.add(entry.getKey());
        }
        System.out.println(eventSet.toString());
        return eventSet;
    }
    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        return myMap.get(e);
    }
    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) throws NullPointerException {
        if(category == null) throw new NullPointerException();
        Map<Event, Set<Time>> filteredMap = new TreeMap<>();
        for(Map.Entry<Event, Set<Time>> entry : myMap.entrySet()) {
            if(entry.getKey().getCategory() == category) {
                filteredMap.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println(filteredMap.isEmpty());
        return filteredMap;
    }
    @Override
    public Set<Time> deleteEvent(Event e) throws NullPointerException {
        Set<Time> timeSet = new HashSet<>();
        if(e == null) throw new NullPointerException();
        for(Map.Entry<Event, Set<Time>> entry : myMap.entrySet()) {
            if(entry.getKey() == e) {
                System.out.println("before removal");
                timeSet = entry.getValue();
                this.myMap.remove(e);
                return timeSet;
            }
        }

        return null;
    }
    @Override
    public boolean deleteTime(Event e, Time t) throws NullPointerException{
        if(e == null || t == null) throw new NullPointerException();
        for(Map.Entry<Event, Set<Time>> entry : myMap.entrySet()) {
            if(entry.getKey() == e && entry.getValue().contains(t)) {
                myMap.get(e).remove(t);
                return true;

            }
        }

        return false;
    }
}
