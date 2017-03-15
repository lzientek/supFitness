<%-- 
    Document   : areYouSure
    Created on : 5 févr. 2016, 16:47:34
    Author     : 15256
--%>

<jsp:include page="topPage.jsp" />

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 well">
        <h3>${message}</h3>

        <form method="post" class="col-md-1">
            <button name="yes" class="btn btn-danger btn-lg" >Yes</button>
        </form>
        <div class="col-md-1 col-md-offset-1">
            <button type="button" onclick="history.back();" name="yes" class="btn btn-success btn-lg" >No</button>
        </div>
    </div>
</div>
<jsp:include page="bottomPage.jsp" />
