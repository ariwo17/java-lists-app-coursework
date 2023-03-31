<%@ page import="java.util.List" %>
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
  <h1>Search Result</h1>
  <% String searchstring = request.getParameter("searchstring");
    if (searchstring != null && !searchstring.isEmpty()) { %>
  <p>Search keyword is: <%= searchstring %></p>
  <% } %>
  <%
    List<ItemList> itemLists = (List<ItemList>) request.getAttribute("itemListResult");
    List<Item> items = (List<Item>) request.getAttribute("itemResult");
    List<ItemList> allItemLists = (List<ItemList>) request.getAttribute("itemLists");
    if (itemLists.size() != 0)
    {
  %>
  <h2>ItemLists:</h2>
  <ul>
    <%
      for (ItemList itemList : itemLists)
      {
        String href = "itemList?id=" + itemList.getId();
        String output = "<b>" + itemList.getId() + ".</b> " + itemList.getTitle();
    %>
    <li class="itemLink"><a href="<%=href%>"><%=output%>&nbsp;</a>
    </li>
    <div class="itemListSeparator"></div>
    <% }
    } else
    {%>
    <p>No ItemLists found</p>
    <%}%>
  </ul>

  <%
    if (items.size() != 0)
    {
  %>
  <h2>Items:</h2>
  <ul>
    <%
      for (Item item : items)
      {
        String href = null;
        String output = null;
        String styleClass = null;
        String parentId = null;
        if(!item.getIsItemList()){
          for (ItemList allItemList : allItemLists) {
            for (Item allItem : allItemList.getItems()) {
              if (allItem.getId() == item.getId()) {
                parentId = String.valueOf(allItemList.getId());
              }
            }
          }
          href = "item?id=" + parentId + "&item_id=" + item.getId();
          output = "<b>" + item.getId() + ".</b> " + item.getBody();
          styleClass = "itemLink";
        }
        else {
          href = "itemList?id=" + item.getItemListId();
          output = "► <stuff style='color: mediumblue;'><b>" + item.getItemListId() + ".</b> <i>" + item.getItemList().getTitle() + "</i></stuff>";
          styleClass = "itemLinkToItemList";
        }
    %>
    <li class="itemLink"><a href="<%=href%>"><%=output%>&nbsp;</a>
    </li>
    <div class="itemListSeparator"></div>
    <% }
    } else
    {%>
    <p>No Items found</p>
    <%}%>
  </ul>





</div>
<jsp:include page="/footer.jsp"/>
</body>
<style>
  body {
    background-color: lightseagreen;
  }

  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
  }

  a {
    color: black;
    text-decoration: none; /* no underline */
  }

  .itemLink {
    padding: 10px;
    background-color: aqua;
    border: 2px solid black;
  }

  .itemListSeparator {
    padding: 2px;
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

</style>
</html>
