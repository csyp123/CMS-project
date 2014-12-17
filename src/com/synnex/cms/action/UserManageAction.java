package com.synnex.cms.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.synnex.cms.entity.User;
import com.synnex.cms.service.UserService;

public class UserManageAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	private User user = new User();
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public User getModel() {		
		return user;
	}
	public String Userregist(){
		try {
			if (userService.save(user)) {
				return SUCCESS;				
			}else{
				ActionContext.getContext().put("errmsg", "你注册的用户名已存在，请重设");	
				return ERROR;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

		
		
	}

	
	


