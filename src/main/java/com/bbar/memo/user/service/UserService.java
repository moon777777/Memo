package com.bbar.memo.user.service;

import org.springframework.stereotype.Service;

import com.bbar.memo.common.MD5HashingEncoder;
import com.bbar.memo.user.domain.User;
import com.bbar.memo.user.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	// autowired 를 위한 생성자만 존재하는 경우 생략 가능
//	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean addUser(String loginId
			, String password
			, String name
			, String email) {
		
		String endcodingPassword = MD5HashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, endcodingPassword, name, email);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public User getUser(String loginId
			, String password) {
		
		String endcodingPassword = MD5HashingEncoder.encode(password);
		
		return userRepository.selectUser(loginId, endcodingPassword);
		
		
	}

}
