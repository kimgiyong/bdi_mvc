package com.bdi.mvc.service;

import java.util.List;

import com.bdi.mvc.vo.UserInfo;

public interface UserInfoService {
	public List<UserInfo> userInfoList();
	public UserInfo userInfoView(int ui);
	public String userInfoInsert(UserInfo ui);
	public String userInfoUpdate(UserInfo ui);
	public String userInfoDelete(int ui);
}
