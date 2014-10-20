package com.jason19659.blog.dao;

import java.util.Date;
import java.util.List;

import com.jason19659.blog.model.Article;
import com.jason19659.blog.model.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
    
    int countArticleReply(int article_id);
    
    List<Reply> showReplies(int article_id);
    
    List<Reply> selectLatest10DESC();
    
    int countByIp(String ip,Date before,Date after);
}