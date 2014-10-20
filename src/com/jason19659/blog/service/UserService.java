/**
 * 
 */
package com.jason19659.blog.service;

import java.util.List;

import com.jason19659.blog.model.User;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.service
 *
 * 2014年3月18日
 */

public interface UserService {
	int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAll();
    
    
}
