package com.bin.javabase.compareDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ɫҵ����
* ��Ŀ���ƣ�CollectionDemo   
* �����ƣ�RoleBiz   
* ��������
* �����ˣ������   
* ����ʱ�䣺2017��11��17�� ����6:43:30   
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
