package com.jyty.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyty.dao.DaoSupport;
import com.jyty.entity.Project;
import com.jyty.util.ReqData;

/**
 * 文章
 * @author Administrator
 *
 */
@Service("projectService")
public class ProjectService {
	@Resource(name = "daoSupport")
	private DaoSupport dao; 
	
	
	/**
	 * 项目详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Project getProjectById(int id) throws Exception {	
		return (Project) dao.findForObject("ProjectMapper.getProjectItem", id);
	}
	public Object addNewProject(ReqData rData) throws Exception {
		return dao.save("ProjectMapper.addProject", rData);
	}
}
