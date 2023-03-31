<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <jsp:include page="/meta.jsp"/>
  <title>Lists App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<marquee class="welcome">Welcome to the Lists App, an OOP coursework project developed in Maven. It uses JSON to store your itemLists locally. The styling is minimalistic as you can see, but I like it as it lets you focus on the backend.</marquee>

<nav>
  <ul>
    <li>
      <a class="navlink" href="itemLists.html">View your itemLists</a>
    </li>
    <br>
    <li>
      <a class="navlink" href="search.jsp">Search your itemLists</a>
    </li>
  </ul>

</nav>
</body>
<style>
  .welcome {
    background-color: black;
    color: white;
  }
  body {
    background-color: lightseagreen;
  }

  .navlink {
    font-size: 18px;
    text-decoration: none;
    border-style: solid;
    border-color: black;
    border-width: 1px;
    background-color: aqua;
    color: black;
    padding: 5px;
    margin-left: -40px;
  }

  .navlink:hover {
    color: blue;
  }

  .appLogo {
  }
</style>
</html>