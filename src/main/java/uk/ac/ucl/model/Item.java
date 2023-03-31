package uk.ac.ucl.model;

public class Item {
    private int id;
    private String body;
    private ItemList itemList;
    private int itemListId;
    private boolean isItemList;

    public Item(int id, String body, int itemListId, boolean isItemList) {
        this.id = id;
        this.body = body;
        this.itemListId = itemListId;
        this.isItemList = isItemList;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public ItemList getItemList() { return itemList; }
    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }

    public int getItemListId() {
        return itemListId;
    }
    public boolean getIsItemList() {
        return isItemList;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
