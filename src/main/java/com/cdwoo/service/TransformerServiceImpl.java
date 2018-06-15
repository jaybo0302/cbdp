package com.cdwoo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdwoo.common.CDPage;
import com.cdwoo.dao.TransformerDao;
import com.cdwoo.entity.Transformer;
import com.cdwoo.entity.TransformerParam;

@Service
public class TransformerServiceImpl implements TransformerService {

	@Autowired
	private TransformerDao transformerDao;
	@Override
	public void addTransformer(Transformer t) {
		transformerDao.addTransformer(t);
	}
	@Override
	public CDPage queryTransformerByPage(TransformerParam param) {
		CDPage page = new CDPage();
		page.setCount(param.getPageSize());
		page.setCurrentPage(param.getPageNo());
		page.setTotalCount(transformerDao.queryTransformerCount(param));
		List<Object> result= transformerDao.queryTransformerByPage(param);
		page.setData(result);
		return page;
	}
	@Override
	public void deleteTransformer(String id) {
		this.transformerDao.deleteTransformer(id);
	}
	@Override
	public Transformer getTransformerById(String id) {
		return this.transformerDao.getTransformerById(id);
	}
	@Override
	public void editTransformer(Transformer transformer) {
		this.transformerDao.editTransformer(transformer);
	}

}
