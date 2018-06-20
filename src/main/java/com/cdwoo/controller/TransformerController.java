/**
 * 
 */
package com.cdwoo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdwoo.common.CDPage;
import com.cdwoo.common.CDResult;
import com.cdwoo.entity.Transformer;
import com.cdwoo.entity.TransformerParam;
import com.cdwoo.service.TransformerService;

/**
 * @author cd
 *
 */
@Controller
@RequestMapping("transformer")
public class TransformerController {
	
	@Autowired
	private TransformerService transformerService;
	@ResponseBody
	@RequestMapping("addTransformer")
	public CDResult addTransformer(Transformer transformer) {
		try {
			this.transformerService.addTransformer(transformer);
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("添加失败");
		}
		return CDResult.success();
	}
	
	@ResponseBody
	@RequestMapping("queryTransformerByPage")
	public CDPage queryTransformerByPage(TransformerParam param) {
		CDPage page = this.transformerService.queryTransformerByPage(param);
		return page;
	}
	
	@ResponseBody
	@RequestMapping("deleteTransformer")
	public CDResult deleteTransformer(HttpServletRequest req) {
		String id = req.getParameter("id");
		try {
			this.transformerService.deleteTransformer(id);
			return CDResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("删除失败");
		}
	}
	
	@RequestMapping("getEditPage")
	public String getEditPage(@RequestParam("id") String id, HttpServletRequest req) {
		Transformer t = this.transformerService.getTransformerById(id);
		req.getSession().setAttribute("t", t);
		return "/jsp/transformer_edit";
	}
	
	@ResponseBody
	@RequestMapping("editTransformer")
	public CDResult editTransformer(Transformer transformer) {
		try {
			this.transformerService.editTransformer(transformer);
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("修改失败");
		}
		return CDResult.success();
	}
}
