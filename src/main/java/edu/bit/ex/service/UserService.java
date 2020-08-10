package edu.bit.ex.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class UserService {
	
	@Inject
	//실제에서 가장많이 쓰는 암호화(나온거중 가장 우수)스프링 내장함수
	private BCryptPasswordEncoder passEncoder;
	
	@Inject
	private UserMapper userMapper;
	
	public void addUser(UserVO userVO){
		String password = userVO.getPassword();
		String encode = passEncoder.encode(password);
		
		userVO.setPassword(encode);
		
		userMapper.insertUser(userVO);
		userMapper.insertAuthorities(userVO);
	}
}
