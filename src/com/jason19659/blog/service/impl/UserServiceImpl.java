/**
 * 
 */
package com.jason19659.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason19659.blog.dao.UserMapper;
import com.jason19659.blog.model.User;
import com.jason19659.blog.service.UserService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.service.impl
 *
 * 2014年3月20日
 */
@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	/* 
	 * @see com.jason19659.blog.service.UserService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.blog.service.UserService#insert(com.jason19659.blog.model.User)
	 */
	@Override
	public int insert(User record) {
		
		return userMapper.insert(record);
	}

	/* 
	 * @see com.jason19659.blog.service.UserService#insertSelective(com.jason19659.blog.model.User)
	 */
	@Override
	public int insertSelective(User record) {
		return userMapper.insert(record);
	}

	/* 
	 * @see com.jason19659.blog.service.UserService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/* 
	 * @see com.jason19659.blog.service.UserService#updateByPrimaryKeySelective(com.jason19659.blog.model.User)
	 */
	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	/* 
	 * @see com.jason19659.blog.service.UserService#updateByPrimaryKey(com.jason19659.blog.model.User)
	 */
	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/* 
	 * @see com.jason19659.blog.service.UserService#selectAll()
	 */
	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

}
