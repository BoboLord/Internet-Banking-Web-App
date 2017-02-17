<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="email" class="form-control" placeholder="Email ID"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control"
                            placeholder="Password Confirmation"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="account1">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="account1" path="account1" class="form-control" placeholder="Primary Account"></form:input>
                <form:errors path="account1"></form:errors>
            </div>
        </spring:bind>
        


        <spring:bind path="firstname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="firstname" path="firstname" class="form-control" placeholder="First Name"></form:input>
                <form:errors path="firstname"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="lastname" path="lastname" class="form-control" placeholder="Last Name"></form:input>
                <form:errors path="lastname"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="phone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="phone" path="phone" class="form-control" placeholder="Mobile Number"></form:input>
                <form:errors path="phone"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="DOB">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="DOB" path="DOB" class="form-control" placeholder="Date of Birth"></form:input>
                <form:errors path="DOB"></form:errors>
            </div>
        </spring:bind>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
