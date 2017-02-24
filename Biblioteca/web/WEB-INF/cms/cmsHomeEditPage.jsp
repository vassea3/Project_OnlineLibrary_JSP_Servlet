<%@include file="cmsCommon/cmsHeader.jspf" %>
<div class="addBookForm" >
    <h1>Edit home page</h1>
    <form action="cmsEditHomePage" method="POST" enctype="multipart/form-data">  
        <table style="width: 70%; margin: 0 auto;" >
            <tr>
                <td class="addBookFormCimp" style="width: 28%;"> 
                    <label> Site Title:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="siteTitle" value="${home.siteTitle}"/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">    
                    <label>First text on the slide: </label
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="slideText1" value="${home.slideText1}"/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">    
                    <label>Secont text on the slide: </label
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="slideText2" value="${home.slideText2}"/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">    
                    <label>Third text on the slide: </label
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="slideText3" value="${home.slideText3}"/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">   
                    <label> First image on the slide:</label>
                </td>
                <td class="addBookFormCimp">
                    <input  type="file" name="slideImg1" value="${home.slideImg1}"/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">   
                    <label> Second image on the slide:</label>
                </td>
                <td class="addBookFormCimp">
                    <input  type="file" name="slideImg2" value="${home.slideImg2}"/>
                </td>
            </tr>
            <tr> 
                <td class="addBookFormCimp">   
                    <label> Third image on the slide:</label>
                </td>
                <td class="addBookFormCimp">
                    <input  type="file" name="slideImg3" value="${home.slideImg3}"/>
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