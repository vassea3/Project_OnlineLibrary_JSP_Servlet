<%@include file="cmsCommon/cmsHeader.jspf" %>
<div class="addBookForm" >
    <h1>Edit about page</h1>
    <form action="cmsEditAboutPage" method="POST" enctype="multipart/form-data"> 
        <table style="width: 70%; margin: 0 auto;" >
            <tr>
                <td class="addBookFormCimp" style="width: 28%;"> 
                    <label> About ${siteTitle}:</label>
                </td>
                <td class="addBookFormCimp">
                    <textarea class="addBookFormTextArea" name="aboutLib" >${about.aboutLib}</textarea>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">   
                    <label>Library image:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="file" name="libImage" value="${about.libImage}" width="30" />
                </td>
            </tr>
            <tr>
                <td colspan="2" class="addBookFormBotton">
                    <input type="submit"  value="Update"/>
                </td>
            </tr>
        </table>
    </form>
</div>





<%@include file="cmsCommon/cmsFooter.jspf" %>