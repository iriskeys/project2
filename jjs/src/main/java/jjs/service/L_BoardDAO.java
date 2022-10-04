package jjs.service;

import java.util.List;

public interface L_BoardDAO {

	public void LBoardInsert(L_BoardVO L_boardVO) throws Exception;
	
	public void LBoardUpdate(L_BoardVO L_boardVO) throws Exception;
	
	public void LBoardDelete(L_BoardVO L_boardVO) throws Exception;
	
	public L_BoardVO LBoardDetail(L_BoardVO L_boardVO) throws Exception;
	
	public List<L_BoardVO> selectLBoardList(BoardSearchVO searchVO) throws Exception;
	
	public int LBoardTotal(BoardSearchVO searchVO) throws Exception;
	
	public void LBoardCnt();
	
	public void LBoardCnt2();
	 
}
