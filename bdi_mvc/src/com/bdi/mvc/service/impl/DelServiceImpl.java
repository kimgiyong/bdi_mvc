package com.bdi.mvc.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.dao.DelDAO;
import com.bdi.mvc.dao.impl.DelDAOImpl;
import com.bdi.mvc.service.DelService;

public class DelServiceImpl implements DelService {
	private DelDAO ddao = new DelDAOImpl();

	@Override
	public List<Map<String, String>> getDelList() throws SQLException {
		// TODO Auto-generated method stub
		return ddao.selectDelList();
	}

	@Override
	public Map<String, String> getDel(int num) throws SQLException {
		// TODO Auto-generated method stub
		return ddao.selectDel(num);
	}

	@Override
	public List<Map<String, String>> deleteDels(String[] nums) throws SQLException {
		int cnt = ddao.deleteDels(nums);
		return ddao.selectDelList();
	}

	@Override
	public int insertService(String name, int age) throws SQLException {
		// TODO Auto-generated method stub
		return ddao.insertDAO(name, age);
	}

	@Override
	public int updateService(int num, String name, String age) throws SQLException {
		// TODO Auto-generated method stub
		return ddao.updateDAO(num, name, age);
	}
	

}
