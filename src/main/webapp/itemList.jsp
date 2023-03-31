<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ItemList" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="uk.ac.ucl.model.ItemList" %>
<%@ page import="uk.ac.ucl.model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Lists App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <div class="itemList">
    <%
      ItemList itemList = (ItemList) request.getAttribute("itemList");
      String title = itemList.getTitle();
      LocalDateTime dateTime = itemList.getDateTime();
      int id = itemList.getId();
    %>
    <h2 id="itemListTitle" class="item_text"><%= title %></h2>
    <form>
      <div id="renamePanel">
        <input id="rename" type="button" value="Rename" onclick="makeEditable()">
        <br>
        <input id="save" hidden="hidden" type="button" value="Save" onclick="updateEdit(<%= id %>)">
      </div>

    </form>
    <p id="itemListDateTime" class="item_text"><i>Created at <%= dateTime%></i></p>
    <p id="itemListBody" class="item_text">
      <%
        String body = itemList.getBody();
        String itemId = String.valueOf(itemList.getId());
        String action = "/new_item?id=" + itemId;
      %>
      <%= body %><br><br>
    <a class="addNewItem" href=<%= action %>>Add a new item</a>
    <hr>
    <ul>
      <%
        List<Item> items = itemList.getItems();
        for (Item item : items)
        {
          String href = null;
          String output = null;
          String deleteHref = null;
          String styleClass = null;
          if(!item.getIsItemList()){
            href = "item?id=" + itemList.getId() + "&item_id=" + item.getId();
            output = "<b>" + item.getId() + ".</b> " + item.getBody();
            deleteHref = "deleteItem?id=" + itemList.getId() + "&item_id=" + item.getId();
            styleClass = "itemLink";
          }
          else {
            href = "itemList?id=" + item.getItemListId();
            output = "► <stuff style='color: mediumblue;'><b>" + item.getItemListId() + ".</b> <i>" + item.getItemList().getTitle() + "</i></stuff>";
            deleteHref = "deleteItem?id=" + itemList.getId() + "&item_id=" + item.getId();
            styleClass = "itemLinkToItemList";
          }
      %>
      <li class="<%=styleClass%>"><a href="<%=href%>"><%=output%>&nbsp;</a><a class="deleteItem" href="<%=deleteHref%>">Delete</a>
      </li>
      <div class="itemListSeparator"></div>
      <% } %>
    </ul>
    </p>
  </div>
</div>
<jsp:include page="/footer.jsp"/>
</body>
<style>
  .itemList {
    background-color: beige;
    border-style: solid;
  }

  .item_text {
    margin-left: 10px;
  }

  body {
    background-color: lightseagreen;
  }

  .itemLink {
    padding: 10px;
    background-color: aqua;
    border: 2px solid black;
  }

  .itemLinkToItemList {
    padding: 10px;
    background-color: aqua;
    color: mediumblue;
    border: 2px solid black;
  }

  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
  }

  li {
    margin-left: 10px;
    margin-right: 10px;
  }

  a {
    color: black;
    text-decoration: none; /* no underline */
  }

  #rename {
    padding: 3px;
    background-color: green;
    color: white;
    border: 1px solid black;
  }

  #save {
    padding: 3px;
    background-color: purple;
    color: white;
    border: 1px solid black;
  }

  .addNewItem {
    padding: 3px;
    background-color: darkblue;
    color: white;
    border: 1px solid black;
  }

  .deleteItem {
    padding: 2px;
    margin-left: 2px;
    background-color: #bf0000;
    color: white;
    border: 1px solid black;
  }

  .itemListSeparator {
    padding: 2px;
  }

  #renamePanel {
    margin-left: 10px;
  }

</style>
<script>
  function makeEditable() {
    console.log("Make editable clicked!");
    var e = document.getElementById("itemListTitle");
    var renewBtn = document.getElementById("rename");
    var saveBtn = document.getElementById("save");
    var d = document.createElement('input');
    d.value = e.innerHTML;
    e.parentNode.replaceChild(d, e);
    d.id = "newTitle";
    renewBtn.style.display = "none";
    saveBtn.style.display = "inline-block";
  }

  function updateEdit(id) {
    let e = document.getElementById("newTitle");
    let newUrl = "/rename?id=" + id + "&title=" + e.value;
    let redirectUrl = "/itemList?id=" + id;
    fetch(newUrl, {
      method: 'POST'
    })
            .then(response => window.location.replace(redirectUrl))
  }
</script>
</html>
