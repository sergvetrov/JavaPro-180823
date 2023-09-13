package HW5.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private final List<Record> subscribers = new ArrayList<>();

    public void add (Record subscriber){
        subscribers.add(subscriber);
    }

    public Record find (String name){
        Record record = null;
        for (Record subscriber : subscribers) {
            record = subscriber.getName().equals(name) ? subscriber : null;
        }
        return record;
    }

    public List<Record> findAll(String name){
        List<Record> result = new ArrayList<>();
        for (Record subscriber : subscribers) if(subscriber.getName().equals(name)) result.add(subscriber);
        return result.isEmpty() ? null : result;
    }
}
