<%@include file="cmsCommon/cmsHeader.jspf" %>
<div class="addBookForm" >
    <h1>${bookAddEdit}  </h1>
    <form action="cmsaddbook" method="POST" enctype="multipart/form-data">  
        <input type="text" name="bookId" value="${book.bookId}" readonly="readonly" hidden="hidden"/>
        <table style="width: 40%; margin: 0 auto;">
            <tr>
                <td class="addBookFormCimp" style="width: 30%;" > 
                    <label> Book name:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="bookName" value="${book.bookName}" required=""/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">    
                    <label> Book author:</label
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="author" value="${book.author}" required=""/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">   
                    <label> Book genre:</label>
                </td>
                <td class="addBookFormCimp">
                    <input  type="text" name="gender" value="${book.gender}" required=""/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp" >   
                    <label > Information about book:</label>
                </td>
                <td >
                    <textarea class="addBookFormTextArea" name="summary" required="" >${book.summary}</textarea>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">   
                    <label>Select book file:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="file" name="fileName" value="${book.fileName}" width="30" />${eroare}
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">   
                    <label> Select book image:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="file"  name="bookImageName" value="${book.bookImageName}" width="30" />${eroare}
                </td>
            </tr>
            <tr>
                <td colspan="2" class="addBookFormBotton">
                    <input type="submit"  value="Save"/>
                    <input type="reset" value="Cleen form" />
                </td>
            </tr>
        </table>
    </form>
</div>
<%@include file="cmsCommon/cmsFooter.jspf" %>