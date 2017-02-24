<%@include  file="common/header.jspf" %>
<div id="contacts">  
    <div id="contactMap">
        <div style="width: 98%">
            <iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0"  src="http://www.mapi.ie/create-google-map/map.php?width=100%&amp;height=600&amp;hl=en&amp;q=${contact.city}%20${contact.street}+()&amp;ie=UTF8&amp;t=&amp;z=14&amp;iwloc=A&amp;output=embed" ></iframe>
        </div> 
    </div>
    <div class="contactDetails">
        <h3>Contact Details</h3>
        <p>
            City: ${contact.city}<br>Street: ${contact.street}
        </p>
        Phone : ${contact.phone}</p>
        <p>
            Email: ${contact.email}
        </p>
        <p>
            Work time: ${contact.graphic}</p>
    </div>
</div>
<h1 class="contactText">Contact us</h1>
<div id="contactForm">
    <form action="contactMessage" method="POST">
        <div class="contactPersonalInformation">
            <input type="text" name="name" placeholder="Name">
            <input type="email" name="email" placeholder="Email address">
            <input type="text" name="subject" placeholder="Subject">
        </div>
        <div class="message">
            <textarea name="message" name="message" type="text" placeholder="Message"></textarea>
        </div>  
        <div class="buttonSend">
            <input type="submit" value="Send" >
        </div>
    </form>
</div>
<%@include  file="common/footer.jspf" %>