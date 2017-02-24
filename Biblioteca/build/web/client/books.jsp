<%@include  file="common/header.jspf" %>
<div class="bookGenres" >
    <h3>Select a genre:</h3>
    <ul>
        <c:forEach items="${listaGenre}" var="g">
            <li class="genresLi" ">
                <a  href="searchByGenre?gen=${g}">  ${g}</a>
            </li>
        </c:forEach>
    </ul>
</div>
<div class="book3Cols">
    <h1 > ${bookNameStr} ${genre}  </h1>
    <div class="page">
        <c:forEach items="${listaBooks}" var="b">
            <div class="post">
                <div class="bookAranjare">
                    <div class="bookImg"> 
                        <img src="resources/images/bookImages/${b.bookImageName}  " style="height: 190px"/>
                    </div>
                    <div class="bookName">
                        ${b.bookName}
                    </div>
                    <div class="bookAuthor" >
                        ${b.author } 
                    </div>
                    <a href="oneBook?bookId=${b.bookId}" > Details...  </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<hr style="width: 72%; margin-top: 75%;"/>
<div class="pagination">
</div>

<script src="resources/js/pagination/jqueryPaginate.js" ></script>
<script src="resources/js/pagination/paginate.js"></script>
<script src="resources/js/pagination/custom.js" ></script>
<%@include  file="common/footer.jspf" %>