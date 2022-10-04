package jjs.service;

import java.util.List;

public interface F_BoardDAO {

	void F_BoardInsert(F_BoardVO F_boardVO) throws Exception;
	
	void F_BoardUpdate(F_BoardVO F_boardVO) throws Exception;
	
	void F_BoardDelete(F_BoardVO F_boardVO) throws Exception;
	
	F_BoardVO F_BoardDetail(F_BoardVO F_boardVO) throws Exception;
	
	List<F_BoardVO> selectF_BoardList(BoardSearchVO searchVO) throws Exception;
	
	int F_BoardTotal(BoardSearchVO searchVO) throws Exception;
	
	void F_BoardCnt();
	
	void F_BoardCnt2();
	
}
