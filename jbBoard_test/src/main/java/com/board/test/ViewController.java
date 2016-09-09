package com.board.test;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		return "board_View";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String BoardUpdate(Model model){
		
		return null;
		
	}
	
	@RequestMapping(value="/write", method= RequestMethod.GET)
	public String BoardWrite(Model model){
		
		System.out.println("boardWrite controller");
		
		return "board_Write";
	}
	
	
}
