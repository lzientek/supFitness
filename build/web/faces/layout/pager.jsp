<%-- 
    Document   : pager
    Created on : 4 févr. 2016, 23:20:19
    Author     : 15256
worked with Pager class
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12" style="text-align: center;margin-top: 25px;">
        <ul class="pagination">
            <li class="${pager.isFirstPage?"disabled":""}"><a href="?page=${pager.isFirstPage?0:pager.actualPage-1}">&laquo;</a></li>

            <c:forEach begin="0" end="${pager.numberOfPage-1}" var="i">
                <li class="${pager.actualPage == i?"active":""}" ><a href="?page=${i}">${i+1}</a></li> 
                </c:forEach>

            <li class="${pager.isLastPage?"disabled":""}"><a href="?page=${pager.isLastPage?pager.actualPage:pager.actualPage+1}">&raquo;</a></li>
        </ul>
    </div>
</div>
