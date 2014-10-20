/**
 * 
 */
package com.jason19659.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason19659.blog.model.Json;
import com.jason19659.blog.service.ArticleService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.controller
 *
 * 2014年3月28日
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	private ArticleService articleService;
	@RequestMapping("/{article_id}")
	public String getReply(@PathVariable int article_id,HttpServletRequest request) {
		request.setAttribute("article_id", article_id);
		return "post";
	}
	@RequestMapping("/title/{article_id}")
	@ResponseBody
	public Json idToTitle(@PathVariable int article_id,HttpServletRequest request) {
		Json json = new Json();
		json.setObj(articleService.selectByPrimaryKey(article_id).getTitle());
		json.setMsg("title");
		json.setSuccess(true);
		return json;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}
