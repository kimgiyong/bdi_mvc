package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBConnection;
import com.bdi.mvc.dao.GameChartDAO;
import com.bdi.mvc.vo.GameChart;

public class GameChartDAOImpl implements GameChartDAO {
	private PreparedStatement ps;
	private Connection con;
	@Override
	public List<GameChart> GameChartList() throws SQLException {
		String sql = "select * from game_chart";
		List<GameChart> list = new ArrayList<GameChart>();
		con = DBConnection.getCon();
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				GameChart gc = new GameChart(
						rs.getInt("gcNum"),
						rs.getString("gcName"),
						rs.getInt("gcPrice"),
						rs.getString("gcVendor"),
						rs.getInt("gcOrder"),
						rs.getString("gcDesc"),
						rs.getString("gcImg")
						);
				list.add(gc);
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
		return list;
	}

	@Override
	public GameChart GameChartView(int gcNum) throws SQLException {
		String sql = "select * from game_chart where gcNum = ?";
		con = DBConnection.getCon();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, gcNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				GameChart gc = new GameChart(
						rs.getInt("gcNum"),
						rs.getString("gcName"),
						rs.getInt("gcPrice"),
						rs.getString("gcVendor"),
						rs.getInt("gcOrder"),
						rs.getString("gcDesc"),
						rs.getString("gcImg")
						);
				return gc;
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
		return null;
	}

	@Override
	public int GameChartInsert(GameChart gc) throws SQLException {
		String sql = "insert into game_chart(gcName,gcPrice,gcVendor,gcOrder,gcDesc,gcImg)";
		sql += " values(?,?,?,?,?,?)";
		con = DBConnection.getCon();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, gc.getGcName());
			ps.setInt(2, gc.getGcPrice());
			ps.setString(3, gc.getGcVendor());
			ps.setInt(4, gc.getGcOrder());
			ps.setString(5, gc.getGcDesc());
			ps.setString(6, gc.getGcImg());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
	}

	@Override
	public int GameChartUpdate(GameChart gc) throws SQLException {
		String sql = "update game_chart set gcName = ?,gcPrice = ?,gcVendor = ?,gcOrder = ?,gcDesc = ?,gcImg = ? where gcNum = ?";
		con = DBConnection.getCon();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, gc.getGcName());
			ps.setInt(2, gc.getGcPrice());
			ps.setString(3, gc.getGcVendor());
			ps.setInt(4, gc.getGcOrder());
			ps.setString(5, gc.getGcDesc());
			ps.setString(6, gc.getGcImg());
			ps.setInt(7, gc.getGcNum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
	}

	@Override
	public int GameChartDelete(int gcNum) throws SQLException {
		String sql = "delete from game_chart where gcNum = ?";
		con = DBConnection.getCon();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, gcNum);
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
	}

}
