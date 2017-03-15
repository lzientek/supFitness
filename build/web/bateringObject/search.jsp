<%-- 
    Document   : search
    Created on : 5 févr. 2016, 21:52:15
    Author     : 15256
--%>

<jsp:include page="../layout/topPage.jsp" />
<div class="row">
    <h2>${numberOfObjects} objects found</h2>
</div>

<jsp:include page="partialBateringObject.jsp" />


<jsp:include page="../layout/pager.jsp" />
<jsp:include page="../layout/bottomPage.jsp" />