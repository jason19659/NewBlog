/**
 * 
 */
package com.jason19659.blog.service;

import java.util.Date;
import java.util.List;

import com.jason19659.blog.model.Reply;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.service
 *
 * 2014年3月21日
 */
public interface ReplyService {
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
