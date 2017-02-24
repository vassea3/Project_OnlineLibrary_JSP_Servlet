<%@include file="cmsCommon/cmsHeader.jspf" %>
<div class="book3Cols">
    <h1> Messages:</h1>
    <div class="page">
        <c:forEach items="${listaMessages}" var="m">
            <div class="post">
                <div style="width: 100%">
                    <div class="cmsMessage">
                        <input hidden="hidden" type="text" name="messageId" value="${m.id}" readonly="readonly"/>
                        <p> <label >Name: </label></p>
                        <i>${m.name}</i>
                        <p>  <label >Email: </label></p>
                        <i>${m.email}</i>
                        <p><label >Subject: </label><br/> </p>
                        <i>${m.subject }</i>
                    </div>
                    <div id="cmsMessageRead">
                        <p>   <label >Message: </label> <br/></p>
                        <div id="message">${m.message }</div> 
                        <h3>
                            <a style="text-decoration: none; color: white" href="cmsDeleteMessage?messageId=${m.id}">
                                Delete this message
                            </a>
                        </h3>
                    </div>
                    <hr/>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="pagination">
    </div>
    <div style=" padding-top: 5%; "/>
    <script src="resources/js/pagination/jqueryPaginate.js" ></script>
    <script src="resources/js/pagination/paginate.js"></script>
    <script src="resources/js/pagination/custom.js" ></script>
    <%@include file="cmsCommon/cmsFooter.jspf" %>