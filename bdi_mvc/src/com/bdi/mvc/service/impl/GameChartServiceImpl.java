package com.bdi.mvc.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bdi.mvc.dao.GameChartDAO;
import com.bdi.mvc.dao.impl.GameChartDAOImpl;
import com.bdi.mvc.service.GameChartService;
import com.bdi.mvc.vo.GameChart;

public class GameChartServiceImpl implements GameChartService {
	private GameChartDAO gcd = new GameChartDAOImpl();
	@Override
	public List<GameChart> GameChartList() throws SQLException {
		return gcd.GameChartList();
	}

	@Override
	public GameChart GameChartView(int gcNum) throws SQLException {
		return gcd.GameChartView(gcNum);
	}

	@Override
	public String GameChartInsert(GameChart gc) throws SQLException {
		int cnt = gcd.GameChartInsert(gc);
		String msg = "등록에 실패하였습니다.";
		if(cnt==1) {
			msg = "등록에 성공하였습니다.";
		}
		return msg;
	}

	@Override
	public String GameChartUpdate(GameChart gc) throws SQLException {
		int cnt = gcd.GameChartUpdate(gc);
		String msg = "수정에 실패하였습니다.";
		if(cnt==1) {
			msg = "수정에 성공하였습니다.";
		}
		return msg;
	}

	@Override
	public String GameChartDelete(int gcNum) throws SQLException {
		int cnt = gcd.GameChartDelete(gcNum);
		String msg = "삭제에 실패하였습니다.";
		if(cnt==1) {
			msg = "삭제에 성공하였습니다.";
		}
		return msg;
	}

}
