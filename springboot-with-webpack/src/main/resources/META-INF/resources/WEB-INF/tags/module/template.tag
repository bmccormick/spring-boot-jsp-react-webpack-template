<%@ taglib prefix="module" tagdir="/WEB-INF/tags/module" %>
<%
  request.setCharacterEncoding("utf-8");
  response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <module:title/>
  <module:javascript/>
  <module:css/>
</head>
<body>
  <link rel="stylesheet" type="text/css" href="/dist/css/homepage.css"/>
  <div class="container">
    <div class="header clearfix">
      <nav>
        <ul class="nav nav-pills pull-right">
          <li role="presentation" class="active"><a href="/">Home</a></li>
        </ul>
      </nav>
      <h3 class="text-muted"><a href="/">Mccormi</a></h3>
    </div>

    <jsp:doBody/>

  </div>
</body>
</html>
