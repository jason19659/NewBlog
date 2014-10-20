/**
 * 
 */
package com.jason19659.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason19659.blog.dao.ArticleMapper;
import com.jason19659.blog.model.Article;
import com.jason19659.blog.service.ArticleService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.service.impl
 *
 * 2014年3月20日
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	private ArticleMapper articleMapper;
	public ArticleMapper getArticleMapper() {
		return articleMapper;
	}
	@Autowired
	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}

	/* 
	 * @see com.jason19659.blog.service.ArticleService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return articleMapper.deleteByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.blog.service.ArticleService#insert(com.jason19659.blog.model.Article)
	 */
	@Override
	public int insert(Article record) {
		
		return articleMapper.insert(record);
	}

	/* 
	 * @see com.jason19659.blog.service.ArticleService#insertSelective(com.jason19659.blog.model.Article)
	 */
	@Override
	public int insertSelective(Article record) {
		return articleMapper.insert(record);
	}

	/* 
	 * @see com.jason19659.blog.service.ArticleService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Article selectByPrimaryKey(Integer id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.blog.service.ArticleService#updateByPrimaryKeySelective(com.jason19659.blog.model.Article)
	 */
	@Override
	public int updateByPrimaryKeySelective(Article record) {
		return articleMapper.updateByPrimaryKeySelective(record);
	}

	/* 
	 * @see com.jason19659.blog.service.ArticleService#updateByPrimaryKey(com.jason19659.blog.model.Article)
	 */
	@Override
	public int updateByPrimaryKey(Article record) {
		return articleMapper.updateByPrimaryKey(record);
	}

	/* 
	 * @see com.jason19659.blog.service.ArticleService#selectAllDESC()
	 */
	@Override
	public List<Article> selectAllDESC() {
		return articleMapper.selectAllDESC();
	}
	/* 
	 * @see com.jason19659.blog.service.ArticleService#count()
	 */
	@Override
	public int count() {
		return articleMapper.count();
	}


}
