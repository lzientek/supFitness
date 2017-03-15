<%-- 
    Document   : webservicesHelper
    Created on : 6 févr. 2016, 17:15:03
    Author     : 15256
--%>


<jsp:include page="layout/topPage.jsp" />

<div class="row">
    <div class="col-lg-10 col-lg-offset-1 well">
        <h3>Request objects</h3>
        <p>To request and get all the objects you can follow this link:</p>
        <p><span style="text-decoration: underline;">/api/bateringObject/all</span></p>
        <p>And if you need to load more (it's paginated)</p>

        <p><span style="text-decoration: underline;">/api/bateringObject/all/<strong>{page}</strong></span></p>
        <p>Example : <a href="/api/bateringObject/all/0">/api/bateringObject/all/0</a></p>

        <h3>Search in objects :</h3>
        <p>To search in objects make a GET request on this url:</p>
        <p><span style="text-decoration: underline;">/api/bateringObject/search/<strong>{my search}</strong></span></p>
        <p>And if you need to load more (it's paginated)</p>

        <p><span style="text-decoration: underline;">/api/bateringObject/search/<strong>{my search}</strong>/<strong>{page}</strong></span></p>
        <p>Example (searching for "a"): <a href="/api/bateringObject/search/a/0">/api/bateringObject/search/a/0</a></p>
        
        <p>Example (searching for a price : 2 &euro;): <a href="/api/bateringObject/search/2">/api/bateringObject/search/2</a></p>
    </div>
</div>
<jsp:include page="layout/bottomPage.jsp" />

