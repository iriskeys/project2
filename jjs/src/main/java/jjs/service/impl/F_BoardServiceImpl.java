package jjs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import jjs.service.BoardSearchVO;
import jjs.service.F_BoardDAO;
import jjs.service.F_BoardService;
import jjs.service.F_BoardVO;

@Service("F_boardService")
public class F_BoardServiceImpl implements F_BoardService{
	@Resource(name="F_BoardMyBatis")
	private F_BoardDAO F_boardDAO;
	
	//작동체크
	public F_BoardServiceImpl() throws Exception {
		System.out.println("F_boardServiceImpl 작동");
	}
	//추가
	@Transactional
	@Override
	public void F_BoardInsert(F_BoardVO F_boardVO) throws Exception {
		F_boardDAO.F_BoardInsert(F_boardVO);
	}
	//수정
	@Override
	public void F_BoardUpdate(F_BoardVO F_boardVO) throws Exception {
		F_boardDAO.F_BoardUpdate(F_boardVO);
	}
	//삭제
	@Override
	public void F_BoardDelete(F_BoardVO F_boardVO) throws Exception {
		F_boardDAO.F_BoardDelete(F_boardVO);
	}
	//상세조회
	@Override
	public F_BoardVO F_BoardDetail(F_BoardVO F_boardVO) throws Exception {
		return F_boardDAO.F_BoardDetail(F_boardVO);
	}
	//목록
	@Override
	public List<F_BoardVO> selectF_BoardList(BoardSearchVO searchVO) throws Exception {
		return F_boardDAO.selectF_BoardList(searchVO);
	}
	//갯수
	@Override
	public int F_BoardTotal(BoardSearchVO searchVO) throws Exception {
		return F_boardDAO.F_BoardTotal(searchVO);
	}
	//번호셋팅
	@Override
	public void F_BoardCnt() {
		F_boardDAO.F_BoardCnt();
	}
	//번호셋팅2
	@Override
	public void F_BoardCnt2() {
		F_boardDAO.F_BoardCnt2();
	}

}
