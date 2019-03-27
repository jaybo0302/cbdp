/**
 * 
 */
package com.cdwoo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdwoo.common.Constants;
import com.cdwoo.entity.Role;
import com.cdwoo.entity.User;
import com.cdwoo.service.ResourceService;
import com.cdwoo.service.RoleService;
import com.cdwoo.service.UserService;
import com.cdwoo.utils.CommonUtil;

/**
 * @author cd
 *
 */
@Controller
@RequestMapping("common")
public class CommonController {
	@Autowired 
	private ResourceService resourceService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request, User user) throws  Exception{
        User dbUser = userService.getUserByUserName(user.getUserName());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsp/login");
        if(dbUser == null){
            mav.addObject("errorMsg", "用户名不存在");
        }else if(!(dbUser.getPassword()).equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))){
            mav.addObject("errorMsg", "密码错误");
        }else {
            dbUser.setPassword(null);
            request.getSession().setAttribute(Constants.USER_CONTEXT, dbUser);
            Role r = this.roleService.getRoleById(String.valueOf(dbUser.getRoleId()));
            if (r.getrIds().indexOf(",") != -1) {
            	String rIds = r.getrIds().substring(0, r.getrIds().length() - 1);
        		List<Map<String, Object>> list = this.resourceService.getResourcesByRole(rIds);
        		mav.addObject("rs", list);
            }
            mav.setViewName("jsp/index");
        }
        return mav;
    }
	@RequestMapping("logout")
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute(Constants.USER_CONTEXT);
		return "jsp/login";
	}
	@RequestMapping("index")
	public String index(HttpServletRequest req) {
		User dbUser = (User) req.getSession().getAttribute(Constants.USER_CONTEXT);
		if (dbUser == null) {
			return "jsp/login";
		}
		
		Role r = this.roleService.getRoleById(String.valueOf(dbUser.getRoleId()));
		 if (r.getrIds().indexOf(",") != -1) {
         	String rIds = r.getrIds().substring(0, r.getrIds().length() - 1);
     		List<Map<String, Object>> list = this.resourceService.getResourcesByRole(rIds);
     		req.setAttribute("rs", list);
         }
        return "jsp/index";
	}
}
