<%@include file="cmsCommon/cmsHeader.jspf" %>
<div>   
    <h1>Adminitrator page</h1>
    <break/>
</div>
<div class="containerSlide">
    <div class="arangeSerch">
        <form  action="cmsSearch" method="POST">
            <div class="serchText">
                <input  type="text" name="bookName" placeholder="Search"/>
            </div>
            <div class="serchButton">
                <input type="submit" value="Serch"/>
            </div>
        </form>
    </div>
</div>
<%@include file="cmsCommon/cmsFooter.jspf" %>
