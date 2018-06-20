package com.cdwoo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cdwoo.entity.Transformer;
import com.cdwoo.entity.TransformerParam;

public interface TransformerDao {
	public void addTransformer(Transformer t);
	public List<Object> queryTransformerByPage(TransformerParam param);
	public void deleteTransformer(@Param("id")String id);
	public long queryTransformerCount(TransformerParam param);
	public Transformer getTransformerById(@Param("id")String id);
	public void editTransformer(Transformer transformer);
}
