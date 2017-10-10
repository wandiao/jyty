package com.jyty.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jyty.entity.BaseType;
import com.jyty.entity.Image;
import com.jyty.service.ImageService;
import com.jyty.util.FtpUtil;
import com.jyty.util.ReqData;

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
	@Resource(name="imageService")
	ImageService imageService;
	
	@RequestMapping(value="/add")
	public ModelAndView addImageView(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String msg = request.getParameter("msg");
		String pic_url = request.getParameter("pic_url");
		List<BaseType> types = imageService.getTypes();
		mv.setViewName("image_add");
		mv.addObject("msg", msg);
		mv.addObject("pic_url", pic_url);
		mv.addObject("types", types);
		return mv;
	}
	
	@RequestMapping(value="/add.do")
	public ModelAndView addImage(MultipartFile file, HttpServletRequest request)  {
		ModelAndView mv = new ModelAndView("redirect:/image/add");
		ReqData rData = new ReqData(request);
		Date date = new Date();
		rData.put("create_time", date);
		if (file.isEmpty()) {
			mv.addObject("error_msg", "�ļ�δ�ϴ�");
			return mv;
		}
		String newName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		logger.info(newName);
		//�ϴ���·��  
        String imagePath = new SimpleDateFormat("/yyyy-MM-dd").format(new Date());
      //�˿ں�  
        int port = Integer.parseInt(FTP_PORT); 
        
        try {
		boolean upload_result = FtpUtil.uploadFile(FTP_ADDRESS, port,  
			        FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, imagePath,  
			        newName, file.getInputStream());
		if(!upload_result) {
			mv.addObject("err_msg", "�ϴ�ʧ��");
			return mv;
		}
		String pic_url = IMAGE_BASE_URL + imagePath + "/" + newName;
		rData.put("pic_url", pic_url);
		String result = imageService.addNewImage(rData).toString();
		if (Integer.parseInt(result) == 1) {
			mv.addObject("msg", "�ϴ��ɹ�");
			mv.addObject("pic_url", pic_url);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			mv.addObject("error_msg", "�ϴ��쳣");
			e.printStackTrace();
		} catch (Exception e) {
			mv.addObject("error_msg", "����ʧ��");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/*System.out.println("�ļ�����: " + file.getSize());   
        System.out.println("�ļ�����: " + file.getContentType());   
        System.out.println("�ļ�����: " + file.getName());   
        System.out.println("�ļ�ԭ��: " + file.getOriginalFilename());   
        System.out.println("========================================"); */ 
		
		return mv;
	}
	@RequestMapping(value="/list")
	public ModelAndView Imagelist(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		ReqData rData = new ReqData(request);
		List<Object> images = imageService.getImageList(rData);
		mv.setViewName("image_list");
		mv.addObject("images", images);
		return mv;
	}
	@RequestMapping(value="/type")
	public ModelAndView Imagetype() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("image_type");
		return mv;
	}
}
