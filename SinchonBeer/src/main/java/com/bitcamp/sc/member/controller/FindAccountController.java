package com.bitcamp.sc.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.service.EmailFindService;
import com.bitcamp.sc.member.service.PwFindService;

@Controller
public class FindAccountController {
	// 아이디 찾기 서비스
	@Autowired
	private EmailFindService emailFindService;


	// 비밀번호 찾기 서비스
	@Autowired
	private PwFindService pwFindService;

	
	// 이메일과 비밀번호 찾기 첫번째 화면
	@RequestMapping(value = "/inquiry", method = RequestMethod.GET)
	public String findAccount() {
		return "member/findEmailPwForm";
	}

//--- (1) 아이디 찾기 시작
	//ajax에서 아이디 찾기 (요청)매핑
	@RequestMapping(value = "/inquiry/email", method = RequestMethod.POST)
	@ResponseBody
	public String findEmailByNamePhone(@RequestBody Map<String, Object> params) {

		System.out.println("아이디 찾기 test");
		System.out.println(params);
		System.out.println(params.get("name"));
		System.out.println(params.get("phone"));
		String emailSearch = emailFindService.emailSearch((String) params.get("name"), (String) params.get("phone"));

		System.out.println("컨트롤러에서 DB 갔다 온 emailSearch? : " + emailSearch);

		return emailSearch;
	}
	
//--- (2) 비밀번호 찾기 시작 

	// ajax에서 비밀번호 찾기 (요청) 매핑
	@RequestMapping(value = "/inquiry/pw", method = RequestMethod.POST)
	@ResponseBody
	public String findEmailByNameEmail(@RequestBody Map<String, Object> params) {

		System.out.println("비밀번호 찾기 test");
		System.out.println(params);
		System.out.println(params.get("name"));
		System.out.println(params.get("email"));
		String pwSearch = pwFindService.pwSearch((String) params.get("name"), (String) params.get("email"));

		System.out.println("컨트롤러에서 DB 갔다 온 pwSearch? : " + pwSearch);

		return pwSearch;
	}

}


