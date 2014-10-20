/**
 * 
 */
package test.user;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.jason19659.blog.model.Reply;
import com.jason19659.blog.service.ArticleService;
import com.jason19659.blog.service.ReplyService;
import com.jason19659.blog.service.UserService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * test.user
 *
 * 2014年3月18日
 */
public class UserTest {
	
	private static ApplicationContext context;
	private static UserService userService;
	private static ArticleService articleService;
	private static ReplyService replyService;
	@BeforeClass
	public static void a() {
		context = new ClassPathXmlApplicationContext(new String[]{ "classpath:spring-base.xml","classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"});
		userService = context.getBean(UserService.class);
		articleService = context.getBean(ArticleService.class);
		replyService  = context.getBean(ReplyService.class);
	}
	
	@Test
	public void insertRep() {
		Reply reply = new Reply();
		reply.setDate(new Date());
		reply.setContext("1111");
		replyService.insert(reply);
	}
	
	@Test
	public void add() {
		System.out.println(userService);
		System.out.println(JSON.toJSONString(userService.selectAll()));
	}
	
	@Test
	public void article() {
		System.out.println(JSON.toJSONString(articleService.selectAllDESC()));
	}
	
	@Test
	public void articleCount() {
		System.out.println(JSON.toJSONString(replyService.countArticleReply(1)));
	}
	
	@Test
	public void articleCount2() {
		System.out.println(JSON.toJSONString(articleService.count()));
	}
	
	@Test
	public void showReplies() {
		System.out.println(JSON.toJSONString(replyService.showReplies(1)));
	}
	
	@Test
	public void showReplies2() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.YEAR, 2013);
		System.out.println(replyService.countByIp("127.0.0.1", calendar.getTime(), new Date()));
	}
	
	
}
