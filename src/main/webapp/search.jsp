
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Lists App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Search</h1>
  <form method="POST" action="/runsearch">
    <input type="text" name="searchstring" placeholder="Enter search keyword here"/>
    <input id="search" type="submit" value="Search"/>
  </form>
</div>
</body>
<style>
  body {
    background-color: lightseagreen;
  }

  #search {
    background-color: purple;
    color: white;
    padding: 2px 7px;
    border-style: solid;
    border-width: 1px;
    border-color: black;
    border-radius: 5px;
  }

</style>
</html>