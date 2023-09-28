var slideIndex = 0;

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}
    slides[slideIndex-1].style.display = "block";
    setTimeout(showSlides, 5000);
}

showSlides()

function cancel_blur(name){
    // console.log(name)
    // console.log(document.getElementsByClassName(name)[0])
    document.getElementsByClassName(name)[0].style.filter='blur(0)';
}

function make_blur(name){
    console.log(name + "data loss")
    document.getElementsByClassName(name)[0].style.filter='blur(10px)';
}