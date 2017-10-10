package com.jyty.controller.api;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyty.entity.BaseType;
import com.jyty.entity.Image;
import com.jyty.entity.PageData;
import com.jyty.entity.Project;
import com.jyty.entity.ResponseData;
import com.jyty.service.ImageService;
import com.jyty.util.ReqData;

@CrossOrigin(origins = "*", maxAge = 3600,methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
@Controller
@RequestMapping("/api/image")
public class ImageApiController {
	@Resource(name="imageService")
	ImageService imageService;
	
	@RequestMapping(value="/{id}")
	@ResponseBody
	public ResponseData getArticleDetail(@PathVariable("id") String id) throws Exception {
		ResponseData responseData = new ResponseData();
		if(id == null || "".equals(id)) {
			responseData.failure("文章id不能为空");	
		}else{
			 int imagetid = Integer.parseInt(id);
			Image image = imageService.getImageById( imagetid);
			imageService.addReadNum();
			responseData = responseData.success(image);
		}
		
		return responseData;
	}
	/**
	 * 获取图片列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public ResponseData getArticleList(HttpServletRequest request) throws Exception {
		ResponseData responseData = new ResponseData();
		int pageNum=1;
		int pageSize=0;
		ReqData rData = new ReqData(request);
		if(rData.getString("pageNum")!=null &&! "".equals(rData.getString("pageNum"))){
			pageNum = Integer.parseInt(rData.getString("pageNum"));
		}
		if(rData.getString("pageSize")!=null &&! "".equals(rData.getString("pageSize"))){
			pageSize = Integer.parseInt(rData.getString("pageSize"));
		}
		 PageHelper.startPage(pageNum, pageSize);
		
		List<Object> images = imageService.getImageList(rData);
		PageInfo<Object> page = new PageInfo<Object>(images);
		PageData pd = new PageData();
		pd.setPageNum(page.getPageNum());
		pd.setPageSize(page.getPageSize());
		pd.setDataList(images);
		pd.setTotalCount(page.getTotal());
		pd.setTotalPage(page.getPages());
		
		responseData = responseData.success(pd);
		return responseData;
	}
	
	@RequestMapping(value="/types")
	@ResponseBody
	 public ResponseData getTypes() throws Exception {
		ResponseData responseData = new ResponseData();
		List<BaseType> types = imageService.getTypes();
		responseData.success(types);
		return responseData;
	}
}
