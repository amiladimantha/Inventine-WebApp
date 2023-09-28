$(document).ready(function() {

    const modal = document.querySelector(".modal"); //selects the modal
    const btnCloseModal = document.querySelector(".close-modal"); //selects the button to close the modal
    const btnOpenModal = document.querySelector(".show-modal"); //selects the button to show the modal
    const overlay = document.querySelector(".overlay"); //selects the overlay

    const toggleModal = function () {
        modal.classList.toggle("hidden");
        overlay.classList.toggle("hidden");
    };

    btnOpenModal.addEventListener("click", toggleModal);

    btnCloseModal.addEventListener("click", toggleModal);

    overlay.addEventListener("click", toggleModal);

    var table = $('#example').DataTable({
        select: false,
        "columnDefs": [{
            className: "Name",
            "targets":[0],
            "visible": false,
            "searchable":false
        }]
    });//End of create main table


    $('#example tbody').on( 'click', 'tr', function () {

        alert(table.row( this ).data()[0]);

    } );
});