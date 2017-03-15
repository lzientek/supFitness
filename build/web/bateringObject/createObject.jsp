<%-- 
    Document   : createObject
    Created on : 4 févr. 2016, 15:26:14
    Author     : 15256
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/topPage.jsp" />



<div class="row">
    <div class="col-lg-offset-3 col-lg-6">
        <jsp:include page="../layout/displayError.jsp"/>
        <c:if test="${not empty saveResult}">
            <div class="alert alert-dismissible alert-success">
                <button type="button" class="close" data-dismiss="alert">x</button>
                <strong> ${saveResult}</strong>
            </div>
        </c:if>
        <div class="well bs-component">
            <form class="form-horizontal" method="Post" enctype="multipart/form-data" >
                <fieldset>
                    <legend>${title}</legend>
                    <input type="hidden" value="${obj.id}" name="id" />
                    <div class="form-group">
                        <label for="inputTitle" class="col-lg-3 control-label">Title</label>
                        <div class="col-lg-9">
                            <input class="form-control" id="inputTitle" value="${obj.name}" name="title" placeholder="Object title" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDescr" class="col-lg-3 control-label">Description</label>
                        <div class="col-lg-9">
                            <textarea class="form-control" id="inputDescr" name="description" placeholder="description" >${obj.description}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputImage" class="col-lg-3 control-label">Image</label>
                        <div class="col-lg-9">
                            <input class="form-control" id="inputImage" name="image" type="file">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputType" class="col-lg-3 control-label">Object type</label>
                        <div class="col-lg-9">
                            <select id="inputType" class="form-control" name="objType">
                                <c:forEach items="${objTypes}" var="objType" >
                                    <option ${obj.objectType.id == objType.id?"selected":""} value="${objType.id}">${objType.typeName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPrice" class="col-lg-3 control-label">Price</label>
                        <div class="col-lg-9">
                            <input class="form-control" value="${obj.price}" id="inputPrice" name="price" placeholder="Price" type="number">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-9 col-lg-offset-3">
                            <button type="submit" class="btn btn-primary">${buttonName}</button>
                            <c:if test="${not empty obj.id}">
                                <a class="col-lg-offset-1" href="/object/details?id=${obj.id}">show object</a>
                            </c:if>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>


<jsp:include page="../layout/bottomPage.jsp" />