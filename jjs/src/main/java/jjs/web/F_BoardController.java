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
import jjs.service.F_BoardService;
import jjs.service.F_BoardVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class F_BoardController {
	
	@Resource(name="F_boardService")
	private F_BoardService F_boardService;
	
	@RequestMapping(value = "/Flist.do")
	public String selectF_BoardList(F_BoardVO F_boardVO,Model model,HttpSession session,HttpServletRequest request
			,@RequestParam(required = false,defaultValue = "1")int page
			,@RequestParam(required = false,defaultValue = "1")int range
	        ,@RequestParam(required = false,defaultValue = "FTitle")String searchType
	        ,@RequestParam(required = false)String keyword
	        ,@ModelAttribute("search")BoardSearchVO search)throws Exception {
		
		String userId = "";
		session = request.getSession();
		
		F_boardVO.setUserId(userId);
		
		model.addAttribute("search", search);
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		int listCnt = F_boardService.F_BoardTotal(search);
		search.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", search);
		model.addAttribute("Flist", F_boardService.selectF_BoardList(search));
		
		
		return "F_board/Flist";
	}
	
	@RequestMapping(value = "/FBoardDetail.do")
	public String F_BoardDetail(F_BoardVO F_boardVO,Model model)throws Exception{
		F_boardVO = F_boardService.F_BoardDetail(F_boardVO);
		model.addAttribute("F_board", F_boardVO);
		
		return "F_board/FboardDetail";
	}
	
	@RequestMapping(value = "/FBoardInsert.do",method = RequestMethod.GET)
	public String F_form(F_BoardVO F_boardVO)throws Exception{
		
		return "F_board/Fform";
	}
	
	@RequestMapping(value = "/FboardSuccess.do",method = RequestMethod.GET)
	public String F_BoardInsert(F_BoardVO F_boardVO,HttpSession session,HttpServletRequest request)throws Exception{
		String userId = "";
		session = request.getSession();
		
		F_boardVO.setUserId(userId);
		F_boardService.F_BoardInsert(F_boardVO);
		F_boardService.F_BoardCnt();
		F_boardService.F_BoardCnt2();
		
		return "F_board/Flist";
	}
	@ResponseBody
	@RequestMapping(value = "/FboardUpdate.do")
	public String F_BoardUpdate(F_BoardVO F_boardVO,Model model,HttpSession session,HttpServletRequest request)throws Exception{
		
		String userId = "";
		String data = "";
		
		
		F_boardVO.getFBoardType();
		F_boardVO.getFTitle();
		F_boardVO.getFContent();
		
		if(userId.equals(F_boardVO.getUserId())) {
			F_boardService.F_BoardUpdate(F_boardVO);
			data = "success";
		}else {
			data = "fail";
		}
		
		return data;
	}
	@ResponseBody
	@RequestMapping(value = "/FboardDelete.do")
	public String F_BoardDelete(F_BoardVO F_boardVO,HttpSession session,HttpServletRequest request)throws Exception{

		String userId = "";
		String data = "";
		
		
		
		if(userId.equals(F_boardVO.getUserId())) {
			F_boardService.F_BoardDelete(F_boardVO);
			F_boardService.F_BoardCnt();
			F_boardService.F_BoardCnt2();
			data = "success";
		}else {
			data = "fail";
		}
		return data;
	}
}
