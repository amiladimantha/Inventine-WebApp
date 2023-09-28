function openPage(pageName,elmnt,color,color2) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
        tablinks[i].style.color = "white";
    }
    document.getElementById(pageName).style.display = "block";
    elmnt.style.color = color;
    elmnt.style.backgroundColor = color2;
}


// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();