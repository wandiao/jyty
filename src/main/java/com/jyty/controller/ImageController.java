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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jyty.entity.BaseType;
import com.jyty.entity.Image;
import com.jyty.entity.ResponseData;
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
		String error_msg = request.getParameter("error_msg");
		String msg = request.getParameter("msg");
		String pic_url = request.getParameter("pic_url");
		List<BaseType> types = imageService.getTypes();
		mv.setViewName("image_add");
		mv.addObject("error_msg", error_msg);
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
	@RequestMapping(value="update/{id}")
	public ModelAndView updatePage(@PathVariable("id") int id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			List<BaseType> types = imageService.getTypes();
			mv.addObject("types", types);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Object image = imageService.getImageById(id);
			mv.addObject("image", image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String error_msg = request.getParameter("error_msg");
		String msg = request.getParameter("msg");
		mv.setViewName("image_update");
		mv.addObject("error_msg", error_msg);
		mv.addObject("msg", msg);
		return mv;
	}
	@RequestMapping(value="update/{id}.do")
	public ModelAndView updateAction(MultipartFile file, @PathVariable("id") int id, HttpServletRequest request)  throws Exception {
		ModelAndView mv =  new ModelAndView("redirect:/image/update/" + id);	
		ReqData rData = new ReqData(request);
		Date date = new Date();
		rData.put("update_time", date);
		rData.put("id", id);
		if (!file.isEmpty()) {
			System.out.println("++++++++++++++++++");
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				mv.addObject("error_msg", "�ϴ��쳣");
				e.printStackTrace();
			}
		}
		try {
			String result = imageService.updateImage(rData).toString();
			if (Integer.parseInt(result) == 1) {
				mv.addObject("msg", "�޸ĳɹ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("error_msg", "�޸�ʧ��");
			// TODO: handle exception
		}
		return mv;
	}
	@RequestMapping(value="/delete/{id}.do")
	@ResponseBody
	public ResponseData deleteProject(@PathVariable("id") int id) {
		ResponseData responseData = new ResponseData();
		ReqData rData = new ReqData();
		rData.put("id", id);
		try {
			Object result = imageService.deleteImage(rData);
			responseData.success(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseData.failure("ɾ��ʧ��");
		}
		return responseData;
	}


	@RequestMapping(value="/type")
	public ModelAndView typeproject() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BaseType> types = imageService.getTypes();
		mv.addObject("types", types);
		mv.setViewName("project_type");
		return mv;
	}
	@RequestMapping(value="/type/add.do")
	public ModelAndView addType(HttpServletRequest request) throws Exception {
		ModelAndView mv =  new ModelAndView("redirect:/image/type");
		ReqData rData = new ReqData(request);
		Date date = new Date();
		rData.put("create_time", date);
		try {
			Object result = imageService.addType(rData);
			if (Integer.parseInt(result.toString()) == 1) {
				mv.addObject("msg", "�����ɹ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("error_msg", "����ʧ��");
		}
		return mv;
	}
	@RequestMapping(value="/type/update/{id}.do")
	public ModelAndView updateType(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
		ModelAndView mv =  new ModelAndView("redirect:/image/type");
		ReqData rData = new ReqData(request);
		Date date = new Date();
		rData.put("update_time", date);
		rData.put("id", id);
		try {
			Object result = imageService.updateType(rData);
			if (Integer.parseInt(result.toString()) == 1) {
				mv.addObject("msg", "���³ɹ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("error_msg", "����ʧ��");
		}
		return mv;
	}
	
	@RequestMapping(value="/type/delete/{id}.do")
	@ResponseBody
	public ResponseData deleteType(@PathVariable("id") int id) {
		ResponseData responseData = new ResponseData();
		ReqData rData = new ReqData();
		rData.put("id", id);
		try {
			Object result = imageService.deleteType(rData);
			responseData.success(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseData.failure("ɾ��ʧ��");
		}
		return responseData;
	}
}
