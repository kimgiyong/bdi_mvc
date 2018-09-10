package com.bdi.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.bdi.mvc.vo.GameChart;

public interface GameChartDAO {
	public List<GameChart> GameChartList() throws SQLException;
	public GameChart GameChartView(int gcNum) throws SQLException;
	public int GameChartInsert(GameChart gc) throws SQLException;
	public int GameChartUpdate(GameChart gc) throws SQLException;
	public int GameChartDelete(int gcNum) throws SQLException;
}
