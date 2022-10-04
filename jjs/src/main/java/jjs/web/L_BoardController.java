package jjs.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jjs.service.BoardSearchVO;
import jjs.service.L_BoardService;
import jjs.service.L_BoardVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class L_BoardController {
	
	@Resource(name="L_boardService")
	private L_BoardService L_boardService;
	
	@RequestMapping(value = "/Llist.do")
	public String selectL_BoardList(L_BoardVO L_boardVO,Model model,HttpSession session,HttpServletRequest request
			,@RequestParam(required = false,defaultValue = "1")int page
			,@RequestParam(required = false,defaultValue = "1")int range
	        ,@RequestParam(required = false,defaultValue = "LTitle")String searchType
	        ,@RequestParam(required = false)String keyword
	        ,@ModelAttribute("search")BoardSearchVO search)throws Exception {
		
		String userId = "";
		session=request.getSession();
		
		L_boardVO.setUserId(userId);
		
		model.addAttribute("search", search);
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		int listCnt = L_boardService.LBoardTotal(search);
		search.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", search);
		model.addAttribute("L_list", L_boardService.selectLBoardList(search));
		
		return "L_board/Llist";
	}
	
	@RequestMapping(value = "/LboardDetail.do")
	public String L_BoardDetail(L_BoardVO L_boardVO,Model model)throws Exception{
		L_boardVO = L_boardService.LBoardDetail(L_boardVO);
		model.addAttribute("L_board", L_boardVO);
		
		return "L_board/FboardDetail";
	}
	
	@RequestMapping(value = "/Lboardinsertform.do",method = RequestMethod.GET)
	public String L_form(L_BoardVO L_boardVO)throws Exception{
		
		return "L_board/Lform";
	}
	
	@RequestMapping(value = "/LboardSuccess.do",method = RequestMethod.GET)
	public String L_BoardInsert(L_BoardVO L_boardVO,HttpSession session,HttpServletRequest request)throws Exception{

		String userId = "";
		session = request.getSession();
		
		L_boardVO.setUserId(userId);
		L_boardService.LBoardInsert(L_boardVO);
		L_boardService.LBoardCnt();
		L_boardService.LBoardCnt2();	
		
		return "L_board/Llist";
	}
	@ResponseBody
	@RequestMapping(value = "/LboardUpdate.do")
	public String L_BoardUpdate(L_BoardVO L_boardVO,Model model,HttpSession session,HttpServletRequest request)throws Exception{
		
		String userId = "";
		String data = "";
		
		session = request.getSession();
		L_boardVO.getLBoardType();
		L_boardVO.getLTitle();
		L_boardVO.getLContent();
		
		if(userId.equals(L_boardVO.getUserId())) {
			L_boardService.LBoardUpdate(L_boardVO);
			data = "success";
		}else {
			data = "fail";
		}		

		return data;
	}
	@ResponseBody
	@RequestMapping(value = "/LboardDelete.do")
	public String L_BoardDelete(L_BoardVO L_boardVO,HttpSession session,HttpServletRequest request)throws Exception{
		
		String userId = "";
		String data = "";
		
		session = request.getSession();
		
		if(userId.equals(L_boardVO.getUserId())) {
			L_boardService.LBoardDelete(L_boardVO);
			L_boardService.LBoardCnt();
			L_boardService.LBoardCnt2();
			data = "success";
		}else {
			data = "fail";
		}
		
		return data;
	}
}
