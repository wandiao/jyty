package com.jyty.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyty.dao.DaoSupport;
import com.jyty.entity.BaseType;
import com.jyty.entity.Image;
import com.jyty.entity.Project;
import com.jyty.util.ReqData;

@Service("imageService")
@SuppressWarnings("unchecked")
public class ImageService {
	@Resource(name = "daoSupport")
	private DaoSupport dao; 
	
	/**
	 * ÐÂÔöÍ¼Æ¬
	 * @param rData
	 * @return
	 * @throws Exception
	 */
	public Object addNewImage(ReqData rData) throws Exception {
		return dao.save("ImageMapper.addImage", rData);
	}
	public List<BaseType> getTypes() throws Exception {
		return (List<BaseType>) dao.findForList("ImageMapper.getTypes", null);
	}
	
	public List<Object> getImageList(ReqData rData) throws Exception {
		return (List<Object>) dao.findForList("ImageMapper.getImageList", rData);
	}
	public Image getImageById(int id) throws Exception {	
		return (Image) dao.findForObject("ImageMapper.getImageItem", id);
	}
	public Object addReadNum() throws Exception {
		return  dao.update("ImageMapper.addReadNum", null);
	}
	public Object updateImage(ReqData rData) throws Exception {
		return dao.update("ImageMapper.updateImage", rData);
	}
	
	public Object deleteImage(ReqData rData) throws Exception {
		return dao.delete("ImageMapper.deleteImage", rData);
	}
	public Object addType(ReqData rData) throws Exception {
		return dao.delete("ImageMapper.addType", rData);
	}
	
	public Object updateType(ReqData rData) throws Exception {
		return dao.delete("ImageMapper.updateType", rData);
	}
	
	public Object deleteType(ReqData rData) throws Exception {
		return dao.delete("ImageMapper.deleteType", rData);
	}
}
