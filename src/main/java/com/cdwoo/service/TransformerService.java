package com.cdwoo.service;

import com.cdwoo.common.CDPage;
import com.cdwoo.entity.Transformer;
import com.cdwoo.entity.TransformerParam;

public interface TransformerService {
	public void addTransformer(Transformer t);

	public CDPage queryTransformerByPage(TransformerParam param);

	public void deleteTransformer(String id);

	public Transformer getTransformerById(String id);

	public void editTransformer(Transformer transformer);
}
