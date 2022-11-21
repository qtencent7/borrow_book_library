package com.example.springbootdemo01.controller;

import com.example.springbootdemo01.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;

@Controller
@RequestMapping("/app")
public class MainController {

    @GetMapping("/test")
    @ResponseBody
    public String handleIndex() {
        return "test";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public String handleData(@RequestBody(required = false) Person person) {
        System.out.println(person);
        return "data";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleUpload(@RequestPart MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        File directory = new File("");
        String path = directory.getCanonicalPath();
        path = path + "\\uploadDir";
        System.out.println("path");
        System.out.println(path);
        String filePath = path + "\\" + fileName;
        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        return "upload";
    }

    @RequestMapping(value ="/download", method = RequestMethod.GET)
    @ResponseBody
    public String download(HttpServletResponse response, String filename) {
        try {
            // path是指想要下载的文件的路径
            File directory = new File("");
            String path = directory.getCanonicalPath();
            String filePath = path + "\\" + filename;
            File file = new File(filePath);
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "donwload";
    }
}
