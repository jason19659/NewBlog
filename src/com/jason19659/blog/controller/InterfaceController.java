/**
 * 
 */
package com.jason19659.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jason19659.blog.model.Article;
import com.jason19659.blog.model.Json;
import com.jason19659.blog.model.Reply;
import com.jason19659.blog.model.exchange.ExchangeArticle;
import com.jason19659.blog.service.ArticleService;
import com.jason19659.blog.service.ReplyService;
import com.jason19659.blog.service.UserService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.controller
 *
 * 2014年3月23日
 */
@Controller
@RequestMapping("/interface")
public class InterfaceController {
	private ArticleService articleService;
	private ReplyService replyService;
	private UserService userService;
	List<ExchangeArticle> articles ;
	
	@RequestMapping("/article")
	@ResponseBody
	public Json getArticle() {
		Json json = new Json();
		articles = new ArrayList<ExchangeArticle>();
		try {
			json.setMsg("article");
			json.setSuccess(true);
			List<Article> as = articleService.selectAllDESC();
			for (Article a : as) {
				articles.add(new ExchangeArticle(a,replyService.countArticleReply(a.getId())));
			}
			json.setObj(articles);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setObj(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping("/article/{article_id}")
	@ResponseBody
	public Json getArticle(@PathVariable int article_id) {
		Json json = new Json();
		try {
			json.setSuccess(true);
			json.setMsg("article");
			json.setObj(new ExchangeArticle(articleService.selectByPrimaryKey(article_id),replyService.countArticleReply(article_id)));
		} catch (Exception e) {
			json.setSuccess(false);
			json.setObj(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping("/reply/{article_id}")
	@ResponseBody
	public Json getReply(@PathVariable int article_id) {
		Json json = new Json();
		List<Reply> replies = replyService.showReplies(article_id);
		try {
			if (replies.size() > 0) {
				json.setMsg("reply");
				json.setSuccess(true);
				json.setObj(replies);
			} else {
				json.setMsg("no replies");
				json.setSuccess(false);
			}
			
		} catch (Exception e) {
			json.setSuccess(false);
			json.setObj(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping("/latestReply")
	@ResponseBody
	public Json getLatestReply() {
		Json json = new Json();
		List<Reply> replies = replyService.selectLatest10DESC();
		try {
			if (replies.size() > 0) {
				json.setMsg("reply");
				json.setSuccess(true);
				json.setObj(replies);
			} else {
				json.setMsg("no replies");
				json.setSuccess(false);
			}
			
		} catch (Exception e) {
			json.setSuccess(false);
			json.setObj(e.getMessage());
		}
		return json;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public ReplyService getReplyService() {
		return replyService;
	}
	@Autowired
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
