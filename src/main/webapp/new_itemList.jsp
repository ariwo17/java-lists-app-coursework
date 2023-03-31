<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ItemList" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Lists App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Add a new itemList...</h2>
  <form method = "post" action = "/new_itemList">
    <fieldset style="background-color: aqua;">
      <label for="title">Title:</label>
      <br>
      <input type="text" id="title" name="title"><br><br>
      <label for="body">Description:</label>
      <br>
      <textarea id="body" name="body" rows="5" cols="20"></textarea><br><br>
      <input class="addNewItemList" id="add_itemList" name="add_itemList" type="submit" value="Add" />
    </fieldset>
  </form>
</div>
<jsp:include page="/footer.jsp"/>
</body>
<style>
  body {
    background-color: lightseagreen;
  }

  .addNewItemList {
    background-color: darkblue;
    color: white;
    border: 1px solid black;
  }
</style>
</html>
