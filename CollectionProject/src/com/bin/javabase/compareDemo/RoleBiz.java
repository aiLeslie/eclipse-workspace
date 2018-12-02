package com.bin.javabase.compareDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色业务类
* 项目名称：CollectionDemo   
* 类名称：RoleBiz   
* 类描述：
* 创建人：李玮斌   
* 创建时间：2017年11月17日 下午6:43:30   
* @version 1.0
 */
public class RoleBiz {
	List<Role> roleList = null;

	public RoleBiz() {
		roleList = new ArrayList<>();
	}
	public void addRole(Role role) {
		roleList.add(role);
	}
	public void removeRole(Role role) {
		if(role == null)return;
		roleList.remove(role);
	}

}
