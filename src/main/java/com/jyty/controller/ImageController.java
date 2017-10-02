package com.jyty.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jyty.util.FtpUtil;

@Controller
@RequestMapping(value="/image")
public class ImageController {
	//��ȡip��ַ  
    @Value("${FTP_ADDRESS}")  
    private String FTP_ADDRESS;  
    //�˿ں�  
    @Value("${FTP_PORT}")  
    private String FTP_PORT;  
    //�û���  
    @Value("${FTP_USERNAME}")  
    private String FTP_USERNAME;  
    //����  
    @Value("${FTP_PASSWORD}")  
    private String FTP_PASSWORD;  
    //����·��  
    @Value("${FTP_BASEPATH}")  
    private String FTP_BASEPATH;  
    //���ص�ַ�ػ���url  
    @Value("${IMAGE_BASE_URL}")  
    private String IMAGE_BASE_URL;
    
	private  Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/add")
	public ModelAndView addImageView() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("image_add");
		return mv;
	}
	
	@RequestMapping(value="/add.do")
	public ModelAndView addImage(MultipartFile file, HttpServletRequest request)  {
		ModelAndView mv = new ModelAndView("redirect:/image/add");
		if (file.isEmpty()) {
			mv.addObject("error_msg", "�ļ�δ�ϴ�");
			return mv;
		}
		String newName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		logger.info(newName);
		//�ϴ���·��  
        String imagePath = new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
        logger.info(imagePath);
      //�˿ں�  
        int port = Integer.parseInt(FTP_PORT); 
        try {
		boolean result = FtpUtil.uploadFile(FTP_ADDRESS, port,  
			        FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, imagePath,  
			        newName, file.getInputStream());
		if(!result) {
			mv.addObject("err_message", "�ϴ�ʧ��");
			mv.addObject("pic_url", IMAGE_BASE_URL + imagePath + newName);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			mv.addObject("error", "�ϴ��쳣");
			e.printStackTrace();
		} 
		System.out.println("�ļ�����: " + file.getSize());   
        System.out.println("�ļ�����: " + file.getContentType());   
        System.out.println("�ļ�����: " + file.getName());   
        System.out.println("�ļ�ԭ��: " + file.getOriginalFilename());   
        System.out.println("========================================");  
		
		return mv;
	}
	@RequestMapping(value="/list")
	public ModelAndView Imagelist() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("image_list");
		return mv;
	}
	@RequestMapping(value="/type")
	public ModelAndView Imagetype() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("image_type");
		return mv;
	}
}
