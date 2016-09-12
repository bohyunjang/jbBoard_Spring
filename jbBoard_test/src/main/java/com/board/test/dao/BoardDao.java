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
	
	public BoardVo selectOne(int seq){
		System.out.println("boardDao... selectOne..");
		
		return this.boardMapper.selectOne(seq);
	}
	
	public int seqMax(){
		//게시판 seq의 최대 값을 가져온다.
		
		System.out.println("baordDao... seqMax");

		return this.boardMapper.seqMax();
	}
	
	public void insert(BoardVo boardVo){
		
		System.out.println("boardDao... insert..");
		
		this.boardMapper.insert(boardVo);
	}
	
	public void update(BoardVo boardVo){
		
		System.out.println("boardDao... update..");
		
		this.boardMapper.update(boardVo);
	}
	
	public void delete(int seq){
		
		System.out.println("boardDao... delete..");
		
		this.boardMapper.delete(seq);
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
