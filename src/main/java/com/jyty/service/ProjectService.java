package com.jyty.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyty.dao.DaoSupport;
import com.jyty.entity.BaseType;
import com.jyty.entity.Project;
import com.jyty.util.ReqData;

/**
 * ��Ŀ
 * @author Administrator
 *
 */
@Service("projectService")
@SuppressWarnings("unchecked")
public class ProjectService {
	@Resource(name = "daoSupport")
	private DaoSupport dao; 
	
	
	/**
	 * ��Ŀ����
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Project getProjectById(int id) throws Exception {	
		return (Project) dao.findForObject("ProjectMapper.getProjectItem", id);
	}
	
	/**
	 * ������Ŀ
	 * @param rData
	 * @return
	 * @throws Exception
	 */
	public Object addNewProject(ReqData rData) throws Exception {
		return dao.save("ProjectMapper.addProject", rData);
	}
	
	/**
	 * ��ȡ��Ŀ���з���
	 * @return
	 * @throws Exception
	 */
	public List<BaseType> getTypes() throws Exception {
		return (List<BaseType>) dao.findForList("ProjectMapper.getTypes", null);
	}
	
	/**
	 * ��ȡ��Ŀ�б�
	 * @param rData
	 * @return
	 * @throws Exception
	 */
	public List<Object> getProjectList(ReqData rData) throws Exception {
		return (List<Object>) dao.findForList("ProjectMapper.getProjectList", rData);
	}
	
	/**
	 * �����Ķ���
	 * @return
	 * @throws Exception
	 */
	public Object addReadNum() throws Exception {
		return  dao.update("ProjectMapper.addReadNum", null);
	}
	
	public Object updateProject(ReqData rData) throws Exception {
		return dao.update("ProjectMapper.updateObject", rData);
	}
	
}
