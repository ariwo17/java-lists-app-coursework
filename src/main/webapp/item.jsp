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
      Item item = (Item) request.getAttribute("item");
      String id = (String) request.getAttribute("id");
      String body = item.getBody();
      String itemId = String.valueOf(item.getId());
      String action = "/new_item?id=" + itemId;
    %>
    <h2 id="itemBody" class="item_text"><%= body %></h2>
    <form>
      <div id="editPanel">
        <input id="edit" type="button" value="Edit" onclick="makeEditable()">
        <br>
        <input id="save" hidden="hidden" type="button" value="Save" onclick="updateEdit(<%= id %>, <%= itemId %>)">
      </div>

    </form>
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

  #edit {
    padding: 3px;
    background-color: orange;
    color: black;
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

  #editPanel {
    margin-left: 10px;
  }

</style>
<script>
  function makeEditable() {
    console.log("Make editable clicked!");
    var e = document.getElementById("itemBody");
    var renewBtn = document.getElementById("edit");
    var saveBtn = document.getElementById("save");
    var d = document.createElement('input');
    d.value = e.innerHTML;
    e.parentNode.replaceChild(d, e);
    d.id = "newBody";
    renewBtn.style.display = "none";
    saveBtn.style.display = "inline-block";
  }

  function updateEdit(id, item_id) {
    let e = document.getElementById("newBody");
    let newUrl = "/edit?id=" + id + "&item_id=" + item_id + "&body=" + e.value;
    let redirectUrl = "/itemList?id=" + id;
    console.log(newUrl);
    fetch(newUrl, {
      method: 'POST'
    })
            .then(response => window.location.replace(redirectUrl))
  }
</script>
</html>
