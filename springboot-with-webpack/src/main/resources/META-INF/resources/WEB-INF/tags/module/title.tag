<%@ attribute name="title" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty title}">
  <title>Spring With Webpack</title>
</c:if>
<c:if test="${!empty title}">
  <title>${title}</title>
</c:if>

