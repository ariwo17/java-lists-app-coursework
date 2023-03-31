<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ItemList" %>
<%@ page import="uk.ac.ucl.model.ItemList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <link rel="stylesheet" href="styles.css">
  <title>Lists App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Recent Lists:</h2>
  <form action = "/new_itemList" method = "get">
    <input class="addNewItemList" type="submit" value="Add a new itemList" />
  </form>
  <br>
  <hr>
  <ul>
    <%
      List<ItemList> itemLists = (List<ItemList>) request.getAttribute("itemLists");
      for (ItemList itemList : itemLists)
      {
        String href = "itemList?id=" + itemList.getId();
        String output = "<b>" + itemList.getId() + ".</b> " + itemList.getTitle();
        String deleteHref = "delete?id=" + itemList.getId();
    %>
    <li class="itemLink"><a href="<%=href%>"><%=output%>&nbsp;</a><a class="deleteItemList" href="<%=deleteHref%>">Delete</a>
    </li>
    <div class="itemListSeparator"></div>
    <% } %>
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

  .addNewItemList {
    padding: 3px;
    background-color: darkblue;
    color: white;
    border: 1px solid black;
  }

  .deleteItemList {
    background-color: #bf0000;
    color: white;
    border: 1px solid black;
  }

  .itemListSeparator {
    padding: 2px;
  }

</style>
</html>
