<%-- 
    Document   : createAccount
    Created on : 1 févr. 2016, 23:04:14
    Author     : 15256
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/topPage.jsp" />

<div class="row">
    <div class="col-lg-offset-3 col-lg-6">
        <c:if test="${not empty saveResult}">
            <div class="alert alert-dismissible alert-success">
                <button type="button" class="close" data-dismiss="alert">x</button>
                <strong> ${saveResult}</strong>
            </div>
        </c:if>
        <jsp:include page="../layout/displayError.jsp"/>
        <div class="well bs-component">
            <form class="form-horizontal" method="Post" >
                <fieldset>
                    <legend>${title}</legend>

                    <div class="form-group">
                        <label for="inputUserName" class="col-lg-3 control-label">Username</label>
                        <div class="col-lg-9">
                            <input class="form-control disabled" id="inputUserName" disabled="disabled" value="${acc.userName}" placeholder="Username" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFirstName" class="col-lg-3 control-label">First Name</label>
                        <div class="col-lg-9">
                            <input class="form-control" id="inputFirstName" name="firstName" value="${acc.firstName}" placeholder="First name" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputLastName" class="col-lg-3 control-label">Last Name</label>
                        <div class="col-lg-9">
                            <input class="form-control" id="inputLastName" name="lastName" value="${acc.lastName}" placeholder="Last name" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-3 control-label">Email</label>
                        <div class="col-lg-9">
                            <input class="form-control" id="inputEmail" name="email" value="${acc.email}" placeholder="Email" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPostCode" class="col-lg-3 control-label">Postal Code</label>
                        <div class="col-lg-9">
                            <input class="form-control" id="inputPostCode" name="postalCode" value="${acc.postalCode}" placeholder="Postal code" type="number">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-9 col-lg-offset-3">
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../layout/bottomPage.jsp" />
