package com.jyty.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyty.dao.DaoSupport;
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
}
