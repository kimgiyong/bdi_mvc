package com.bdi.mvc.dao;

import java.util.List;

import com.bdi.mvc.vo.UserInfo;

public interface UserInfoDAO {
	public List<UserInfo> userInfoList();
	public UserInfo userInfoView(int ui);
	public int userInfoInsert(UserInfo ui);
	public int userInfoUpdate(UserInfo ui);
	public int userInfoDelete(int ui);
}
