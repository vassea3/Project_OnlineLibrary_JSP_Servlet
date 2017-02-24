<%@include  file="common/header.jspf" %>
<div class="oneBookAranjare" >
    <h1> ${oneBook.bookName}</h1>
    <h2>Genre: ${oneBook.gender}</h2>
    <div class="oneBookImage"> 
        <img src="resources/images/bookImages/${oneBook.bookImageName}  "/>
    </div>
    <div class="oneBookSummary" >
        <h2 style="text-align: center;">About "${oneBook.bookName}" </h2>
        ${oneBook.summary}
    </div>    
</div>
<div class="oneBookInformation">
    <br/>
    Author: ${oneBook.author} <br/>
    Download book: <a href="resources/bookFiles/${oneBook.fileName}" download="">${oneBook.fileName}</a>
</div>
<%@include  file="common/footer.jspf" %>