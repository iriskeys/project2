package jjs.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import jjs.service.BoardSearchVO;
import jjs.service.L_BoardDAO;
import jjs.service.L_BoardVO;
@Repository("L_BoardMyBatis")
public class L_BoardDAOMyBatis extends EgovAbstractMapper implements L_BoardDAO{

	@Override
	public void LBoardInsert(L_BoardVO L_boardVO) throws Exception {
		insert("LBoardInsert", L_boardVO);
	}

	@Override
	public void LBoardUpdate(L_BoardVO L_boardVO) throws Exception {
		update("LBoardUpdate", L_boardVO);
	}

	@Override
	public void LBoardDelete(L_BoardVO L_boardVO) throws Exception {
		delete("LBoardDelete", L_boardVO);
	}

	@Override
	public L_BoardVO LBoardDetail(L_BoardVO L_boardVO) throws Exception {
		return selectOne("LBoardDetail", L_boardVO);
	}

	@Override
	public List<L_BoardVO> selectLBoardList(BoardSearchVO searchVO) throws Exception {
		return selectList("LBoardList", searchVO);
	}

	@Override
	public int LBoardTotal(BoardSearchVO searchVO) throws Exception {
		return selectOne("LBoardTotal", searchVO);
	}

	@Override
	public void LBoardCnt() {
		selectOne("LBoardCnt");
	}

	@Override
	public void LBoardCnt2() {
		selectOne("LBoardCnt2");
	}

}
