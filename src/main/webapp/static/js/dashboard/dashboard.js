let sidebar = document.querySelector(".sidebar");
let closeBtn = document.querySelector("#btn");

closeBtn.addEventListener("click", ()=>{
            sidebar.classList.toggle("open");
            menuBtnChange();//calling the function
});

// code for sidebar icon change and header movement
function menuBtnChange() {
            if(sidebar.classList.contains("open")){
                closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");
                document.getElementById("header").style.width = 'calc(100% - 225px)';//replacing the iocns class
                document.getElementById("main").style.width = 'calc(100% - 225px)';
                document.getElementById("title").style.display = "none";
            }else {
                closeBtn.classList.replace("bx-menu-alt-right","bx-menu");
                document.getElementById("header").style.width = 'calc(100% - 78px)';//replacing the iocns class
                document.getElementById("main").style.width = 'calc(100% - 78px)';
                document.getElementById("title").style.display = "initial";
            }
}



