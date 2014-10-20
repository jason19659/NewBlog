/**
 * 
 */
package com.jason19659.blog.model.exchange;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.jason19659.blog.model.Article;
import com.jason19659.blog.util.JsonDateSerializer;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.model.exchange
 *
 * 2014年3月26日
 */
public class ExchangeArticle {
		private Integer id;

	    private Integer authorId;

	    private String title;

	    private String context;

	    private Date date;
	    
	    private int replyCount;
	    
	    public ExchangeArticle(){}

		public ExchangeArticle(Integer id, Integer authorId, String title,
				String context, Date date, int replyCount) {
			super();
			this.id = id;
			this.authorId = authorId;
			this.title = title;
			this.context = context;
			this.date = date;
			this.replyCount = replyCount;
		}
		
		public ExchangeArticle(Article a, int replyCount) {
			super();
			this.id = a.getId();
			this.authorId = a.getAuthorId();
			this.title = a.getTitle();
			this.context = a.getContext();
			this.date = a.getDate();
			this.replyCount = replyCount;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getAuthorId() {
			return authorId;
		}

		public void setAuthorId(Integer authorId) {
			this.authorId = authorId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContext() {
			return context;
		}

		public void setContext(String context) {
			this.context = context;
		}
		
		@JsonSerialize(using=JsonDateSerializer.class)
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getReplyCount() {
			return replyCount;
		}

		public void setReplyCount(int replyCount) {
			this.replyCount = replyCount;
		}
	    
	    
}
