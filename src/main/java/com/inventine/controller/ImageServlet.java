package com.inventine.controller;

import com.inventine.dao.ImageDaoImplementation;
import com.inventine.model.Image;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet(name = "ImageServlet", value = "/image/*")
@MultipartConfig(maxFileSize = 16177215)
public class ImageServlet extends HttpServlet {

    private Image img = new Image();
    private ImageDaoImplementation imgDao = new ImageDaoImplementation();
    private byte[] img_data = null;
    private String imageId = null;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        imageId = uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        if(!imageId.isEmpty()){

            img = imgDao.getImage(imageId);
            img_data = img.getData();

            response.setContentType(img.getContentType());
            ServletOutputStream sos = response.getOutputStream();

            sos.write(img_data);
            sos.close();

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        boolean ok;

        // obtains the upload file part in this multipart request
        Part image_part = request.getPart("image");

        InputStream inputStream = null;

        if (image_part != null) {

            img.setSize((int)image_part.getSize());
            img.setContentType(image_part.getContentType());

            inputStream = image_part.getInputStream();
            img_data = inputStream.readAllBytes();

        }


        if (img_data != null) {

            imageId = Long.toString(System.currentTimeMillis());

            ok = img.setId(imageId);
            ok = img.setData(img_data);

            if(ok){
                ok = imgDao.create(img);
            }

            response.setHeader("Content-Type", "text/plain");
            response.setHeader("success", "yes");
            PrintWriter writer = response.getWriter();
            writer.write(imageId);
            writer.close();

        }

    }
}