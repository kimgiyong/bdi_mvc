package com.bdi.mvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.dao.MakerDAO;
import com.bdi.mvc.dao.impl.MakerDAOImpl;
import com.bdi.mvc.vo.Maker;

public class MakerServiceImpl implements com.bdi.mvc.service.MakerService {

	private MakerDAO md = new MakerDAOImpl();
	@Override
	public List<Maker> getMakerList(Maker mk) {
		return md.selectMakerList(mk);
	}

	@Override
	public Maker getMaker(int mNum) {
		// TODO Auto-generated method stub
		return md.selectMaker(mNum);
	}

	@Override
	public Map<String, Object> insertMaker(Maker mk) {
		Map<String, Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "메이커 등록 오류!");
		rMap.put("success", "false");
		if(md.insertMaker(mk)==1) {
			if(md.updateMakerTotal(mk.getMnum())==1) {
				rMap.put("msg", "정상적으로 등록 되었습니다.");
				rMap.put("success", "true");
			}
		}
		return rMap;
	}

	@Override
	public Map<String, Object> updateMaker(Maker mk) {
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "수정 실패");
		rMap.put("success", "flase");
		int cnt = md.updateMaker(mk);
		if(cnt==1) {
			rMap.put("msg", "수정 성공");
			rMap.put("success", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> deleteMaker(int mk) {
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "메이커 삭제 오류!");
		rMap.put("success", "false");
		if(md.deleteMaker(mk)==1) {
			rMap.put("msg", "정상적으로 삭제 되었습니다.");
			rMap.put("success", "true");
		}
		return rMap;
	}

}
