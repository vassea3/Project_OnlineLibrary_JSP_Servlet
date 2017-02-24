function show_alert() {
    var txt;
    var r = confirm("Delete this book");
    
    if (r == true) {
        txt = "cmsdeletebook?bookId=${b.bookId}";
    } else if(r==false){
        txt = "cmslistabook";
    }
    document.getElementById("delete").innerJSP = txt;
}