package com.bdi.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.bdi.mvc.vo.GameChart;

public interface GameChartService {
	public List<GameChart> GameChartList() throws SQLException;
	public GameChart GameChartView(int gcNum) throws SQLException;
	public String GameChartInsert(GameChart gc) throws SQLException;
	public String GameChartUpdate(GameChart gc) throws SQLException;
	public String GameChartDelete(int gcNum) throws SQLException;
}
