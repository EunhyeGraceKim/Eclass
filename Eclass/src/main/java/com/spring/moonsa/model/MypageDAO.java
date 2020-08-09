package com.spring.moonsa.model;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.nari.model.MemberVO;

@Repository
public class MypageDAO implements InterMypageDAO {

	@Resource
	private SqlSessionTemplate sqlsession;

	
	// 로그인한 학생 정보 불러오기
	@Override
	public MemberVO getSInfo(HashMap<String, String> paraMap) {
		MemberVO membervo = sqlsession.selectOne("mypage.getSInfo", paraMap);
		return membervo;
	}

	// 교과목 리스트 불러오기
	@Override
	public List<HashMap<String, String>> getSubjectList(HashMap<String, String> paraMap) {
		List<HashMap<String, String>> subjectList = sqlsession.selectList("mypage.getSubjectList", paraMap);
		return subjectList;
	}

	// 해당 학생의 출석 리스트 불러오기
	@Override
	public List<AttandVO> getAttandList(HashMap<String, String> paraMap) {
		List<AttandVO> attandList = sqlsession.selectList("mypage.getAttandList", paraMap);
		return attandList;
	}

	// 총 출석 수 가져오기
	@Override
	public String getAttandOX(HashMap<String, String> paraMap) {
		String attandOX = sqlsession.selectOne("mypage.getAttandOX", paraMap);
		return attandOX;
	}

	
	
}
