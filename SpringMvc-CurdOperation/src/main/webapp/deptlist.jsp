<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
    <h2>Department list</h2>
    <ul>
        <c:forEach var="depts" items="${depts}">
            <li> ${depts.id }, ${depts.name}, ${depts.location}</li>
        </c:forEach>
    </ul>

 

</body>