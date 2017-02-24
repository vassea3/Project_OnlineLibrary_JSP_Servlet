<%@include  file="common/header.jspf" %>
<div class="containerSlide">
    <div class="arangeSerch">
        <form  action="serch" method="POST">
            <div class="serchText">
                <input  type="text" name="bookName" placeholder="Serch"/>
            </div>
            <div class="serchButton">
                <input type="submit" value="Search"/>
            </div>
        </form>
    </div>
</div>
<header id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <div class="fill" style="background-image:url('resources/images/pageImages/${home.slideImg1}');"></div>
            <div class="carousel-caption">
                <p class="textOnSlyde">${home.slideText1}</p>
            </div>
        </div>
        <div class="item">
            <div class="fill" style="background-image:url('resources/images/pageImages/${home.slideImg2}');"></div>
            <div class="carousel-caption">
                <p class="textOnSlyde">${home.slideText2}</p>
            </div>
        </div>
        <div class="item">
            <div class="fill" style="background-image:url('resources/images/pageImages/${home.slideImg3}');"></div>
            <div class="carousel-caption">
                <p class="textOnSlyde">${home.slideText3}</p>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>
</header>

<%@include  file="common/footer.jspf" %>