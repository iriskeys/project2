package jjs.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import jjs.service.BoardSearchVO;
import jjs.service.F_BoardDAO;
import jjs.service.F_BoardVO;
@Repository("F_BoardMyBatis")
public class F_BoardDAOMyBatis extends EgovAbstractMapper implements F_BoardDAO{

	@Override
	public void F_BoardInsert(F_BoardVO F_boardVO) throws Exception {
		insert("FBoardInsert",F_boardVO);
	}

	@Override
	public void F_BoardUpdate(F_BoardVO F_boardVO) throws Exception {
		update("FBoardUpdate", F_boardVO);
	}

	@Override
	public void F_BoardDelete(F_BoardVO F_boardVO) throws Exception {
		delete("FBoardDelete", F_boardVO);
	}

	@Override
	public F_BoardVO F_BoardDetail(F_BoardVO F_boardVO) throws Exception {
		return selectOne("FBoardDetail", F_boardVO);
	}

	@Override
	public List<F_BoardVO> selectF_BoardList(BoardSearchVO searchVO) throws Exception {
		return selectList("selectFBoardList", searchVO);
	}

	@Override
	public int F_BoardTotal(BoardSearchVO searchVO) throws Exception {
		return selectOne("FBoardTotal", searchVO);
	}

	@Override
	public void F_BoardCnt() {
		selectOne("FBoardCnt");
	}

	@Override
	public void F_BoardCnt2() {
		selectOne("FBoardCnt2");
	}

}
