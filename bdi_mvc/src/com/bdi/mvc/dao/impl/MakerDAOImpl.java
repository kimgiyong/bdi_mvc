package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBConnection;
import com.bdi.mvc.dao.MakerDAO;
import com.bdi.mvc.vo.Maker;

public class MakerDAOImpl implements MakerDAO {

	@Override
	public List<Maker> selectMakerList(Maker mk) {
		List<Maker> list = new ArrayList<Maker>();
		Connection con = DBConnection.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select mNum, mName, mPrice, mCnt, mTotal, mDesc from maker";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				mk = new Maker(rs.getInt("mNum"),
						rs.getString("mName"),
						rs.getInt("mPrice"),
						rs.getInt("mCnt"),
						rs.getInt("mTotal"),
						rs.getString("mDesc")
						);
				list.add(mk);
			}
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return list;
	}

	@Override
	public Maker selectMaker(int mNum) {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select mNum, mName, mPrice, mCnt, mTotal, mDesc from maker where mNum = ?";
		try {
			Maker mk;
			ps = con.prepareStatement(sql);
			ps.setInt(1,mNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				mk = new Maker(rs.getInt("mNum"),
						rs.getString("mName"),
						rs.getInt("mPrice"),
						rs.getInt("mCnt"),
						rs.getInt("mTotal"),
						rs.getString("mDesc")
						);
				return mk;
			}
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return null;
	}

	@Override
	public int insertMaker(Maker mk) {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = null;
		String sql = "insert into maker(mName, mPrice, mCnt, mTotal, mDesc) values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,mk.getMname());
			ps.setInt(2,mk.getMprice());
			ps.setInt(3,mk.getMcnt());
			ps.setInt(4,mk.getMtotal());
			ps.setString(5,mk.getMdesc());
			return ps.executeUpdate();
		}catch(SQLException e) {
			
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return 0;
	}

	@Override
	public int updateMaker(Maker mk) {
		Connection con = DBConnection.getCon();
		String sql = "update maker set mName = ?, mPrice = ?, mCnt = ?, mTotal = ?, mDesc = ? where mNum = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mk.getMname());
			ps.setInt(2, mk.getMprice());
			ps.setInt(3, mk.getMcnt());
			ps.setInt(4, mk.getMprice()*mk.getMcnt());
			ps.setString(5, mk.getMdesc());
			ps.setInt(6, mk.getMnum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return 0;
	}

	@Override
	public int deleteMaker(int mk) {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = null;
		String sql = "delete from maker where mNum = ?";
		try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, mk);
			return ps.executeUpdate();
		}catch(SQLException e) {
			
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return 0;
	}

	@Override
	public int updateMakerTotal(int mNum) {
		Connection con = DBConnection.getCon();
		String sql = "update maker set mTotal=mCnt * mPrice where mNum = (select max(mNum) from maker)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return 0;
	}

}
