const img_upload = async (host_url,max_width,max_height,id) => {

    const { value: file } = await Swal.fire({
        title: 'Select image of size '+max_width+"x"+max_height,
        input: 'file',
        inputAttributes: {
            'accept': 'image/*',
        },
        confirmButtonColor: "#0097e6",
    })

    if (file) {

        const reader = new FileReader()
        reader.onload = (e) => {

            let image = new Image();
            let img_id;

            image.onload = function (imageEvent) {

                let canvas = document.createElement('canvas');
                var formdata = new FormData();

                let width = image.width
                let height = image.height
                const ratio = width / height

                if (height < max_height || width < max_width) {

                    Swal.fire({
                        icon: 'error',
                        title: 'Image size is smaller!',
                        text: 'Minimum width is '+max_width+' , Minimum Height is '+max_height,
                        confirmButtonColor: "#0097e6",
                    })

                } else{

                    if (height > max_height) {
                        height *= max_height / height;
                    }

                    if (width > max_width){
                        width *= max_width / width;
                    }

                    canvas.width = width;
                    canvas.height = height;
                    canvas.getContext('2d').drawImage(image, 0, 0, width, height);

                    canvas.toBlob(function (blob){
                        formdata.append('image', blob);
                        let xhr = new XMLHttpRequest();

                        xhr.open('POST', 'http://localhost:8080/inventine_war/image');
                        xhr.send(formdata);

                        const id = null;

                        xhr.onload = () =>{

                            // if(xhr.readyState != 4) return;
                            // return xhr.responseText;
                            // const img_id = document.getElementById(id);
                            // img_id.value = xhr.responseText;
                            // console.log(img_id.value);
                            Swal.fire({
                                title: 'Your uploaded picture',
                                text: xhr.responseText,
                                imageUrl: canvas.toDataURL(),
                                imageAlt: 'The uploaded picture',
                                confirmButtonColor: "#0097e6",
                            })

                        };
                    },file.type);



                    // Swal.fire({
                    //     title: 'Your uploaded picture',
                    //     imageUrl: canvas.toDataURL(),
                    //     imageAlt: 'The uploaded picture',
                    //     confirmButtonColor: "#0097e6",
                    // })

                }

            }

            image.src = e.target.result;

        }

        reader.readAsDataURL(file)

    }

}