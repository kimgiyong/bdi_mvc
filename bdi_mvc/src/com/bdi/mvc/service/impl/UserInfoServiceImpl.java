package com.bdi.mvc.service.impl;

import java.util.List;

import com.bdi.mvc.dao.UserInfoDAO;
import com.bdi.mvc.dao.impl.UserInfoDAOImpl;
import com.bdi.mvc.service.UserInfoService;
import com.bdi.mvc.vo.UserInfo;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uid = new UserInfoDAOImpl();
	@Override
	public List<UserInfo> userInfoList() {
		return uid.userInfoList();
	}

	@Override
	public UserInfo userInfoView(int ui) {
		// TODO Auto-generated method stub
		return uid.userInfoView(ui);
	}

	@Override
	public String userInfoInsert(UserInfo ui) {
		String success = "사용자 등록 실패";
		int cnt = uid.userInfoInsert(ui);
		if(cnt==1) {
			success = "사용자 등록 성공";
		}
		return success;
	}

	@Override
	public String userInfoUpdate(UserInfo ui) {
		String success = "사용자 수정 실패";
		int cnt = uid.userInfoUpdate(ui);
		if(cnt==1) {
			success = "사용자 수정 성공";
		}
		return success;
	}

	@Override
	public String userInfoDelete(int ui) {
		String success = "사용자 삭제 실패";
		int cnt = uid.userInfoDelete(ui);
		if(cnt==1) {
			success = "사용자 삭제 성공";
		}
		return success;
	}

}
