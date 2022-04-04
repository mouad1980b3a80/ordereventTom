
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<html>
<head>
    <!-- FontAwesome -->
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        rel="stylesheet"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
        crossorigin="anonymous"/>

    <!-- styles -->
    <style rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
        crossorigin="anonymous"/>
    <style href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        rel="stylesheet"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
        crossorigin="anonymous"/>
    <!--<style href="${request.contextPath}/resources/css/main.css" rel="stylesheet"/>-->
    <title>Hello JSP!! ggg</title>
</head>
<body styleClass="d-flex flex-column h-100">
<h1 class="page-header display-3">
hihaa  ${name}
<!--<h1>${greeting.message}</h1>
<h1>${string_greeting}</h1> -->
</h1>
<div class="row">
<!-- List group
<c:if test="${not empty todotasks}">

    <ul id="todotasks" class="list-group list-group-flush">
        <c:forEach var="task" begin="0" items="${todotasks}">
            <li class="list-group-item">
                <h4>
                    <span>#${task.id} ${task.name}</span> <span class="pull-right">
                                        </span>
                </h4>
                <p>${task.description}</p>

            </li>
        </c:forEach>
    </ul>
</c:if>
 -->
</div>
</body>
</html>