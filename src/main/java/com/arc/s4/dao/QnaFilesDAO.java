package com.arc.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.arc.s4.model.FilesVO;

@Repository
public class QnaFilesDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaFilesMapper.";
	
	public FilesVO fileSelect(FilesVO filesVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"fileSelect", filesVO);
	}
	
	public int fileDelete(FilesVO filesVO) throws Exception {
		return sqlSession.delete(NAMESPACE+"fileDelete", filesVO);
	}
	
	public List<FilesVO> filesList(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE+"fileList", num);
	}
	
	public int fileWrite(FilesVO qnaFilesVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"fileWrite", qnaFilesVO);
	}
}
