/**
 * 
 */
package com.jason19659.blog.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason19659.blog.dao.ReplyMapper;
import com.jason19659.blog.model.Reply;
import com.jason19659.blog.service.ReplyService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.service.impl
 *
 * 2014年3月20日
 */
@Service
public class ReplyServiceImpl implements ReplyService {
	private ReplyMapper replyMapper;
	/* 
	 * @see com.jason19659.blog.service.ReplyService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return replyMapper.deleteByPrimaryKey(id);
	}

	public ReplyMapper getReplyMapper() {
		return replyMapper;
	}
	
	@Autowired
	public void setReplyMapper(ReplyMapper replyMapper) {
		this.replyMapper = replyMapper;
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#insert(com.jason19659.blog.model.Reply)
	 */
	@Override
	public int insert(Reply record) {
		
		return replyMapper.insert(record);
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#insertSelective(com.jason19659.blog.model.Reply)
	 */
	@Override
	public int insertSelective(Reply record) {
		return replyMapper.insert(record);
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Reply selectByPrimaryKey(Integer id) {
		return replyMapper.selectByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#updateByPrimaryKeySelective(com.jason19659.blog.model.Reply)
	 */
	@Override
	public int updateByPrimaryKeySelective(Reply record) {
		return replyMapper.updateByPrimaryKeySelective(record);
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#updateByPrimaryKey(com.jason19659.blog.model.Reply)
	 */
	@Override
	public int updateByPrimaryKey(Reply record) {
		return replyMapper.updateByPrimaryKey(record);
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#countArticleReply(int)
	 */
	@Override
	public int countArticleReply(int article_id) {
		return replyMapper.countArticleReply(article_id);
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#showReplies(int)
	 */
	@Override
	public List<Reply> showReplies(int article_id) {
		return replyMapper.showReplies(article_id);
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#selectLatest10DESC()
	 */
	@Override
	public List<Reply> selectLatest10DESC() {
		return replyMapper.selectLatest10DESC();
	}

	/* 
	 * @see com.jason19659.blog.service.ReplyService#countByIp(int, java.util.Date, java.util.Date)
	 */
	@Override
	public int countByIp(String ip, Date before, Date after) {
		return replyMapper.countByIp(ip, before, after);
	}


}
