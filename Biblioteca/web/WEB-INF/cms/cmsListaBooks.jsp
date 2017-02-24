<%@include  file="cmsCommon/cmsHeader.jspf" %>
<div class="bookGenres" >
    <h3>Select a genre:</h3>
    <ul>
        <c:forEach items="${listaGenre}" var="g">
            <li class="genresLi" ">
                <a  href="cmsSearchByGenre?gen=${g}">  ${g}</a>
            </li>
        </c:forEach>
    </ul>
</div>
<div class="book3Cols">
    <h1 > ${bookNameStr} ${genre} </h1>
    <h2>${bookName}  </h2>
    <h2> <a href="cmsshowaddbook?bookId=0"  class="addBook" > Add new book  </a></h2>
    <input type="text" name="bookId" value="0" readonly="readonly" hidden="hidden"/>
    <div class="page">
        <c:forEach items="${listaBooks}" var="b">
            <div class="post">
                <div class="bookAranjare" style="height: 330px;">
                    <div class="bookImg"> 
                        <img src="resources/images/bookImages/${b.bookImageName}" style="height: 190px" />
                    </div>
                    <div class="bookName">
                        ${b.bookName}
                    </div>
                    <div class="bookAuthor" >
                        ${b.author } 
                    </div>
                    <a href="cmsdeletebook?bookId=${b.bookId}">Delete this book</a><br/>
                    <a href="cmsshowaddbook?bookId=${b.bookId}" > Edit...  </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<hr style="width: 72%;"/>
<div class="pagination">
</div>
<div style=" margin-top: 5%; "/>
<script src="resources/js/pagination/jqueryPaginate.js" ></script>
<script src="resources/js/pagination/paginate.js"></script>
<script src="resources/js/pagination/custom.js" ></script>
<%@include  file="cmsCommon/cmsFooter.jspf" %>




