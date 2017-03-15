<%-- 
    Document   : detailsObject
    Created on : 5 févr. 2016, 15:24:40
    Author     : 15256
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/jsp/layout/topPage.jsp" />


<div class="row">
    <div class="col-lg-8 col-lg-offset-2 well">
        <div class="col-lg-12">
            <h3>${batObj.name}</h3>
            <img src="/images/${batObj.image}" style="max-width: 100%;" alt="${batObj.name}" />
            
        </div>
        <div class="col-lg-12">
            <p>${batObj.description}</p>
            <p>${batObj.price} euros</p>              
            <p>Type : ${batObj.objectType.typeName} </p>
            <p>posted the ${batObj.creationDate} by ${batObj.creator.firstName} ${batObj.creator.lastName}</p>
        </div>
        <div class="col-lg-6">
            <c:if test="${batObj.creator.id == connectedUser.id}" >
                <div class="col-md-12">
                    <div class="btn-group btn-group-justified">
                        <a href="/auth/object/edit?id=${batObj.id}" class="btn btn-success  btn-xs btn-warning">Edit</a>
                        <a href="/auth/object/delete?id=${batObj.id}" class="btn btn-danger btn-xs">Delete</a>
                    </div>   
                </div>
            </c:if>
        </div>
    </div>
</div>

<jsp:include page="/jsp/layout/bottomPage.jsp" />
