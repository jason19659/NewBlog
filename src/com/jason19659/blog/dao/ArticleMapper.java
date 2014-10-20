package com.jason19659.blog.dao;

import java.util.List;

import com.jason19659.blog.model.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
    
    List<Article> selectAllDESC();
    
    int count();
}