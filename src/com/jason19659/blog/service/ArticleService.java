/**
 * 
 */
package com.jason19659.blog.service;

import java.util.List;

import com.jason19659.blog.model.Article;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.service
 *
 * 2014年3月21日
 */
public interface ArticleService {
	int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectAllDESC();
    
    int count();
}
