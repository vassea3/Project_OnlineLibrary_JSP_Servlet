<%@include file="cmsCommon/cmsHeader.jspf" %>
<div class="addBookForm" >
    <h1>Edit contact page</h1>
    <form action="cmsEditHomePage" method="POST">  
        <table style="width: 50%; margin: 0 auto;" >
            <tr>
                <td class="addBookFormCimp" style="width: 28%;"> 
                    <label> City:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="city" value="${contacts.city}"/>
                </td>
            </tr>
            <tr>
                <td class="addBookFormCimp" style="width: 28%;"> 
                    <label> Street:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="street" value="${contacts.street}"/>
                </td>
            </tr>
            <tr>
                <td class="addBookFormCimp" style="width: 28%;"> 
                    <label> Email:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="email" name="email" value="${contacts.email}"/>
                </td>
            </tr>
            <tr>
                <td class="addBookFormCimp" style="width: 28%;"> 
                    <label> Phone:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="tel" name="phone" value="${contacts.phone}"/>
                </td>       
            </tr>
            <tr>
                <td class="addBookFormCimp" style="width: 28%;"> 
                    <label>Graphic:</label>
                </td>
                <td class="addBookFormCimp">
                    <input type="text" name="graphic" value="${contacts.graphic}"/>
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