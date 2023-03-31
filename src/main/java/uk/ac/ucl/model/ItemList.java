package uk.ac.ucl.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private int id;
    private String title;
    private String body;
    private List<Item> items;
    private LocalDateTime dateTime;

    public ItemList(String id, String title, String body, LocalDateTime dateTime) {
        this.id = Integer.parseInt(id);
        this.title = title;
        this.body = body;
        this.dateTime = dateTime;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Item> getItems() { return items; }

    public void addItem(Item item) {
        items.add(item);
    }
}
