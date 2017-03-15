<%-- 
    Document   : listUserObject
    Created on : 4 févr. 2016, 22:23:46
    Author     : 15256
--%>

<jsp:include page="../layout/topPage.jsp" />
<div class="row">
    <h2>${numberOfObjects} results <span class="small"> <a href="/auth/object/create">add a new object</a></span></h2>
</div>

<jsp:include page="partialBateringObject.jsp" />


<jsp:include page="../layout/pager.jsp" />
<jsp:include page="../layout/bottomPage.jsp" />