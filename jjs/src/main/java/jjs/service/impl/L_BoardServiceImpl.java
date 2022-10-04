package jjs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import jjs.service.BoardSearchVO;
import jjs.service.L_BoardDAO;
import jjs.service.L_BoardService;
import jjs.service.L_BoardVO;

@Service("L_boardService")
public class L_BoardServiceImpl implements L_BoardService{
	@Resource(name="L_BoardMyBatis")
	private L_BoardDAO L_boardDAO;
	
	//작동체크
	public L_BoardServiceImpl()throws Exception{
		System.out.println("L_BoardServiceImpl 작동");
	}
	
	//추가
	@Transactional
	@Override
	public void LBoardInsert(L_BoardVO L_boardVO) throws Exception {
		L_boardVO.setLCreateDate("now()");
		L_boardDAO.LBoardInsert(L_boardVO);
	}
	//수정
	@Override
	public void LBoardUpdate(L_BoardVO L_boardVO) throws Exception {	
		L_boardDAO.LBoardUpdate(L_boardVO);
	}
	//삭제
	@Override
	public void LBoardDelete(L_BoardVO L_boardVO) throws Exception {
		L_boardDAO.LBoardDelete(L_boardVO);
	}
	//상세조회
	@Override
	public L_BoardVO LBoardDetail(L_BoardVO L_boardVO) throws Exception {
		return L_boardDAO.LBoardDetail(L_boardVO);
	}
	//목록
	@Override
	public List<L_BoardVO> selectLBoardList(BoardSearchVO searchVO) throws Exception {
		return L_boardDAO.selectLBoardList(searchVO);
	}
	//갯수
	@Override
	public int LBoardTotal(BoardSearchVO searchVO) throws Exception {
		return L_boardDAO.LBoardTotal(searchVO);
	}
	//번호셋팅
	@Override
	public void LBoardCnt() {
		L_boardDAO.LBoardCnt();
	}
	//번호셋팅2
	@Override
	public void LBoardCnt2() {
		 L_boardDAO.LBoardCnt2();
	}

}
