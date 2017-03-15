<%-- 
    Document   : partialBateringObject
    Created on : 5 févr. 2016, 12:14:58
    Author     : 15256
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row afcktable">
    <c:if test="${bateringObjects.size() > 0}">

        <c:forEach items="${bateringObjects}" var="batObj">
            <div class="col-lg-12 afckingrow">
                <div class="col-lg-5 col-lg-offset-1">
                    <h3>${batObj.name}</h3>
                    <div class="col-md-12">
                        <div class="btn-group btn-group-justified">
                            <a href="/object/details?id=${batObj.id}" class="btn btn-info btn-xs">Details</a>
                            <c:if test="${batObj.creator.id == connectedUser.id}" >
                                <a href="/auth/object/edit?id=${batObj.id}" class="btn btn-success  btn-xs btn-warning">Edit</a>
                                <a href="/auth/object/delete?id=${batObj.id}" class="btn btn-danger btn-xs">Delete</a>
                            </c:if>
                        </div>   
                    </div>
                </div>
                <div class="col-lg-5">
                    <p>${batObj.description}</p>
                    <p>${batObj.price} euros</p>
                    <p>posted the ${batObj.creationDate} by ${batObj.creator.firstName} ${batObj.creator.lastName}</p>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>