package com.todo.base.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.base.entity.UserDetailEntity;
import com.todo.base.form.UserDetailForm;
import com.todo.base.service.UserService;

@Controller
public class SignupController {
	
	@Autowired
	UserService userService;

	/*
	 * signupへアクセスした時に動くメソッド
	 */
	@GetMapping("/signup")
	public String displaySignupForm(Model model, UserDetailForm userDetailForm) {
		
		return "/signup/form";
	}
	
	@PostMapping("/signup/regist")
	public String registUserData(UserDetailForm userDetailForm) {

		// UserDetailEntityのインスタンスを生成、ここに値をsetしていく
		UserDetailEntity userDetail = new UserDetailEntity();

		//UUIDを生成
		UUID uuid = UUID.randomUUID();
		// UUIDをStringに変換
		String insUuid = uuid.toString();
		// 値をset
		userDetail.setUserId(userDetailForm.getUserId());
		userDetail.setUserName(userDetailForm.getUserName());
		userDetail.setPassword(userDetailForm.getUserName());
		userDetail.setEmail(userDetailForm.getEmail());
		userDetail.setUuid(insUuid);

		// userServiceの登録処理を呼び出し
		userService.registUserDetail(userDetail);

		return "/signup/sendMail";
	}

}
