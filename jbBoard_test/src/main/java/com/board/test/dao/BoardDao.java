package com.board.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service(value="BoardDao")
public class BoardDao{
	
	@Resource(name="boardMapper")
	private BoardMapper boardMapper;
	
	public List<BoardVo> getSelect(){
		System.out.println("boardDao..getSelect..");
		
		return this.boardMapper.selectList();
	}
	
	
	
/*
	@Override
	public List<BoardVo> selectList() {
		// TODO Auto-generated method stub
		System.out.println("board Dao selectList...");
		
		return this.selectList();
	}

	@Override
	public BoardVo selectOne(int seq) {
		// TODO Auto-generated method stub
		System.out.println("board Dao selectOne.....");
		
		return this.selectOne(seq);
	}

	@Override
	public void insert(BoardVo boardVo) {
		// TODO Auto-generated method stub
		
		
		System.out.println("board Dao insert.....");
		this.insert(boardVo);
	}

	@Override
	public void update(BoardVo boardVo) {
		// TODO Auto-generated method stub
		
		System.out.println("board Dao update.....");
		this.update(boardVo);
	}

	@Override
	public void delete(int seq) {
		// TODO Auto-generated method stub
		
		System.out.println("board Dao delete......");
		this.delete(seq);
	}*/
}
