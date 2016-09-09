package com.board.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository(value="boardMapper")
public interface BoardMapper {

	List<BoardVo> selectList();

	BoardVo selectOne(int seq);

	void insert(BoardVo boardVo);

	void update(BoardVo boardVo);

	void delete(int seq);
}
