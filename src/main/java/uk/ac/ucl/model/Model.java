package uk.ac.ucl.model;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.time.LocalDateTime;

public class Model
{
  // The example code in this class should be replaced by your Model class code.
  // The data should be stored in a suitable data structure.
  private List<ItemList> itemLists = new ArrayList<>();
  private String path = "./data/itemLists.json";
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  public void readFile(String file) {
    // Read a data file and store the data in your data structure.
    JSONArray itemListsJson = null;
    try {
      itemListsJson = (JSONArray)(new JSONParser().parse(new FileReader(file)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
    Iterator itemListsItr = itemListsJson.iterator();

    while (itemListsItr.hasNext())
    {
      Map itemListMap = (Map)itemListsItr.next();
      String id = (String)itemListMap.get("id");
      String title = (String)itemListMap.get("title");
      String body = (String)itemListMap.get("body");
      System.out.println(id);
      System.out.println(title);
      System.out.println(body);
      String stringDateTime = (String)itemListMap.get("dateTime");
      LocalDateTime dateTime = LocalDateTime.parse(stringDateTime, formatter);
      ItemList currentItemList = new ItemList(id, title, body, dateTime);
      
      JSONArray jsonItems = (JSONArray)itemListMap.get("items");
      Iterator itemsItr = jsonItems.iterator();
      while (itemsItr.hasNext())
      {
        Map itemMap = (Map)itemsItr.next();
        String itemId = (String)itemMap.get("id");
        String itemBody = (String)itemMap.get("body");
        String list_id = (String)itemMap.get("list_id");
        boolean is_list = (Boolean)itemMap.get("is_list");
        System.out.println("Test 1:" + itemId + "Test 2:" + (is_list ? getItemListById(Integer.parseInt(list_id)) : null));
        Item item = new Item(Integer.parseInt(itemId), itemBody,
                is_list ? Integer.parseInt(list_id) : -1
                , is_list);
        currentItemList.addItem(item);
      }
      itemLists.add(currentItemList);
    }
    for(ItemList itemList:itemLists){
      for(Item item: itemList.getItems()){
        if(item.getIsItemList()){
          item.setItemList(getItemListById(item.getItemListId()));
        }
      }
    }
    System.out.println("Finished");

  }

  public List<ItemList> getItemLists(){
    return itemLists;
  }

  public ItemList getItemListById(int id){
    for(ItemList itemList : itemLists)
    {
      if(itemList.getId() == id){
        return itemList;
      }
    }
    return null;
  }

  public int getNewId(){
    int maxId = 0;
    for(ItemList itemList : itemLists)
    {
      if (itemList.getId() > maxId){
        maxId = itemList.getId();
      }
    }
    return maxId + 1;
  }

  public int getNewItemId(){
    int maxId = 0;
    for(ItemList itemList : itemLists)
    {
      for(Item item : itemList.getItems()){
        if (item.getId() >= maxId){
          maxId = item.getId();
        }
      }
    }
    return maxId + 1;
  }

  public Item getItemByIds(int itemListId, int itemId){
    List<Item> list = getItemListById(itemListId).getItems();
    for (Item item : list) {
      if (item.getId() == itemId){
        return item;
      }
    }
    return null;
  }

  public void createNewItemList(String title, String body){
    ItemList newItemList = new ItemList(String.valueOf(getNewId()), title, body, LocalDateTime.now());
    itemLists.add(newItemList);
    saveToDatabase();
  }

  public void createNewItem(int itemListId, String body, String link){
    Item newItem = null;
    if(link.equals("None")) {
      newItem = new Item(getNewItemId(), body, -1, false);
    }
    else {
      newItem = new Item(getNewItemId(), body, Integer.valueOf(link), true);
      newItem.setItemList(getItemListById(Integer.valueOf(link)));
    }
    ItemList list = getItemListById(itemListId);
    list.addItem(newItem);
    saveToDatabase();
  }

  public void deleteItemListById(int id) {
    itemLists.remove(getItemListById(id));
    saveToDatabase();
  }

  public void deleteItemById(int itemListId, int itemId) {
    List<Item> list = getItemListById(itemListId).getItems();
    for (Item item : list) {
      if (item.getId() == itemId){
        list.remove(item);
        break;
      }
    }
    saveToDatabase();
  }

  public void renameItemListById(int id, String newTitle) {
    getItemListById(id).setTitle(newTitle);
    saveToDatabase();
  }

  public void editItemListByIds(int id, int item_id, String newBody) {
    getItemByIds(id, item_id).setBody(newBody);
    saveToDatabase();
  }
  public void saveToDatabase()
  {

    JSONArray jsonarray = new JSONArray();
    for(ItemList itemList : itemLists)
    {
      JSONObject json = new JSONObject();
      json.put("id", String.valueOf(itemList.getId()));
      json.put("title", itemList.getTitle());
      json.put("body", itemList.getBody());
      json.put("dateTime", itemList.getDateTime().format(formatter));
      JSONArray itemsjsonarray = new JSONArray();
      for (Item item:itemList.getItems()) {
        JSONObject itemjson = new JSONObject();
        itemjson.put("id", String.valueOf(item.getId()));
        itemjson.put("body", item.getBody());
        itemjson.put("is_list", item.getIsItemList());
//        System.out.println(item.getItemList().getId());
        itemjson.put("list_id", item.getIsItemList() ? String.valueOf(item.getItemListId()) : "null");
        itemsjsonarray.add(itemjson);
      }
      json.put("items", itemsjsonarray);
      jsonarray.add(json);
    }

    try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
      out.write(jsonarray.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  public List<ItemList> getItemListsBySubstring(String substring) {
    List<ItemList> matchingLists = new ArrayList<>();
    for (ItemList itemList : itemLists) {
      String title = itemList.getTitle().toLowerCase();
      String body = itemList.getBody().toLowerCase();
      if (title.contains(substring.toLowerCase()) || body.contains(substring.toLowerCase())) {
        matchingLists.add(itemList);
      }
    }

    return matchingLists;
  }

  public List<Item> getItemsBySubstring(String substring) {
    List<Item> result = new ArrayList<>();
    for(ItemList itemList : itemLists) {
      for(Item item : itemList.getItems()) {
        if(item.getBody().toLowerCase().contains(substring.toLowerCase())) {
          result.add(item);
        }
      }
    }
    return result;
  }


}

