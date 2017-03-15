<%-- 
    Document   : login
    Created on : 1 févr. 2016, 22:01:56
    Author     : 15256
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/topPage.jsp" />

<div class="row">
    <div class="col-lg-offset-3 col-lg-6">
        <jsp:include page="../layout/displayError.jsp"/>
        <c:if test="${not empty msg}" >
            <div class="alert alert-dismissible alert-success">
                <button type="button" class="close" data-dismiss="alert">x</button>
                <strong>Well done!</strong> ${msg}.
            </div>
        </c:if>
        <div class="well bs-component">
            <form class="form-horizontal" method="post">
                <fieldset>
                    <legend>Login</legend>


                    <div class="form-group">
                        <label for="inputUserName" class="col-lg-2 control-label">Username</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputUserName" name="username" placeholder="UserName" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                        <div class="col-lg-10">
                            <input class="form-control" id="inputPassword" name="password" placeholder="Password" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <a href="/register" class="col-md-offset-1">Create an account</a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../layout/bottomPage.jsp" />
