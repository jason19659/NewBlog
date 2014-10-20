/**
 * 
 */
package com.jason19659.blog.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason19659.blog.model.Json;
import com.jason19659.blog.model.Reply;
import com.jason19659.blog.service.ReplyService;
import com.jason19659.blog.util.ReplaceSpecialString;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.controller
 *
 * 2014年4月12日
 */
@Controller
public class ReplyController {
	
	private ReplyService replyService;
	
	@RequestMapping({"/submit","/reply/submit"})
	@ResponseBody
	public Json replySubmit(Reply reply,HttpServletRequest req) {
		Json json = new Json();
		try {
			String ip = req.getRemoteAddr();
			if (true) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				
				calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 15);
				int count = replyService.countByIp(ip, calendar.getTime(), new Date());
				System.out.println(count);
				System.out.println(ip+" "+calendar.getTime()+" "+new Date());
				if (count > 0) {
					json.setMsg("15秒内只能回复一次");
					throw new Exception("回复超过限制");
				}
			}
			json.setObj("reply");
			json.setMsg("回复成功");
			json.setSuccess(true);
			int userId =  req.getSession().getAttribute("userId") != null ? Integer.parseInt((String) req.getSession().getAttribute("userId"))  : -1;
			reply.setIp(ip);
			reply.setUserId(userId);
			reply.setDate(new Date());
			reply.setContext(ReplaceSpecialString.replaceTag(reply.getContext())); 
			reply.setUsername(ReplaceSpecialString.replaceTag(reply.getUsername())); 
			reply.setTitle(ReplaceSpecialString.replaceTag(reply.getTitle())); 
			System.out.println(reply.getContext());
			replyService.insert(reply);
			return json;
		} catch (Exception e) {
			json.setObj("reply");
			json.setSuccess(false);
			e.printStackTrace();
			return json;
		} 
		
		
		
	}

	
	public ReplyService getReplyService() {
		return replyService;
	}
	@Autowired
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
}
