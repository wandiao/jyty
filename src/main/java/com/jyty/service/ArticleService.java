package com.jyty.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyty.dao.DaoSupport;
import com.jyty.entity.Article;
import com.jyty.entity.BaseType;
import com.jyty.util.ReqData;

/**
 * 项目
 * @author Administrator
 *
 */
@Service("articleService")
@SuppressWarnings("unchecked")
public class ArticleService {
	@Resource(name = "daoSupport")
	private DaoSupport dao; 
	
	
	/**
	 * 项目详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Article getProjectById(int id) throws Exception {	
		return (Article) dao.findForObject("ArticleMapper.getArticleItem", id);
	}
	
	/**
	 * 新增项目
	 * @param rData
	 * @return
	 * @throws Exception
	 */
	public Object addNewArticle(ReqData rData) throws Exception {
		return dao.save("ArticleMapper.addArticle", rData);
	}
	
	/**
	 * 获取项目所有分类
	 * @return
	 * @throws Exception
	 */
	public List<BaseType> getTypes() throws Exception {
		return (List<BaseType>) dao.findForList("ArticleMapper.getTypes", null);
	}
	
	/**
	 * 获取项目列表
	 * @param rData
	 * @return
	 * @throws Exception
	 */
	public List<Object> getProjectList(ReqData rData) throws Exception {
		return (List<Object>) dao.findForList("ArticleMapper.getArticleList", rData);
	}
	
	/**
	 * 增加阅读数
	 * @return
	 * @throws Exception
	 */
	public Object addReadNum() throws Exception {
		return  dao.update("ArticleMapper.addReadNum", null);
	}
	
}

