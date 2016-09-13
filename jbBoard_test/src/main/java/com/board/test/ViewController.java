package com.board.test;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.test.dao.BoardDao;
import com.board.test.dao.BoardVo;

@Controller(value="viewController")
public class ViewController {

	@Resource(name="BoardDao")
	private BoardDao boardDao;
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String BoardList(Model model){
		System.out.println("boardList controller");
		//List<BoardVo> list = this.boardDao.selectList();
		List<BoardVo> list = this.boardDao.getSelect();
		model.addAttribute("list", list);
		
		return "board_List";
	}

	@RequestMapping(value="/{seq}")
	public String BoardView(@PathVariable int seq, Model model){
		
		System.out.println("boardView controller");
		BoardVo boardVo = this.boardDao.selectOne(seq);
		System.out.println(boardVo.getSeq());
		
		model.addAttribute("board", boardVo);
		// jsp 화면에서 뿌려질때 어떤 이름의 객체로 뿌려줄것인지 설정
		// model.addAttribute("객체명", db에서 받아온 객체);
	
		return "board_View";
	}	
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String BoardWrite(BoardVo boardVo,//@ModelAttribute("boardVo")  
			RedirectAttributes redirectAttributes){
		
		System.out.println("boardWriteController....");
		
		boardVo.setSeq(boardDao.seqMax()+1);
		this.boardDao.insert(boardVo);
		redirectAttributes.addFlashAttribute("message", "추가되었습니다.");

		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String BoardDelete(@RequestParam(value = "seq") int seq,RedirectAttributes redirectAttributes){
		System.out.println("boardDelete Controller.....");
		
		this.boardDao.delete(seq);
		redirectAttributes.addFlashAttribute("message","삭제되었습니다.");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String BoardUpdate(int seq, RedirectAttributes redirectAttributes, BoardVo boardVo){
		System.out.println("boardUpdate Controller.....");
		
		this.boardDao.update(boardVo);
		redirectAttributes.addFlashAttribute("message","수정되었습니다.");
		return "redirect:/";
	}
	

	/*
	 * jsp 이동 컨트롤러
	 */
	
	@RequestMapping(value="/update_move", method=RequestMethod.GET)
	public String moveBoardUpdate(Model model){
		System.out.println("boardUpdate move controller...");
		
		return "board_Update";
		
	}
	
	@RequestMapping(value="/write_move", method= RequestMethod.GET)
	public String dispBoardWrite(@RequestParam(value = "seq", 
	defaultValue = "0") int seq, Model model) {
		
		System.out.println("boardWriteMove controller..........");
		if(seq>0){
			BoardVo boardVo = this.boardDao.selectOne(seq);
			System.out.println("seq:: "+boardVo.getSeq());
			model.addAttribute("boardVo",boardVo);
		}
		return "board_Write";
	}
	
	
}
