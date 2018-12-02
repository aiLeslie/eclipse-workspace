package com.leslie.javabase.chaper;

import com.leslie.javabase.chaper.iface.IPaper;
import com.leslie.javabase.chaper.iface.IInkBox;
/**
 * ��ӡ���� - ʹ�ñ�׼�ĺںк�ֽ�Ž��д�ӡ
 * @author Administrator
 * @param <IIBox>
 * @param <IIBox>
 * @param <IPaper>
 *
 */
public class Printer {
	
	private IInkBox inkbox ;
	private IPaper paper ;
	
	
	public Printer(){
		/*inkbox = null;
		paper = null;*/
		
	}
	
	public void print(String concent) {
		if(inkbox == null) {
			System.out.println("�ں�û�а�װ�ɹ�~");
			
		}
		if(paper == null) {
			System.out.println("ֽ��û�а�װ�ɹ�~");
			
			
		}
		else {
			System.out.println("����������ɫΪ" + inkbox.getColor());
			System.out.println("ֽ�Ŵ�СΪ" + paper.getSize());
		    System.out.println("��ӡ����Ϊ" + concent);
		}
		return;
	}
	
	public IInkBox getInkbox() {
		return inkbox;
	}
	public void setInkbox(IInkBox inkbox) {
		this.inkbox = inkbox;
	}
	public IPaper getPaper() {
		return paper;
	}
	public void setPaper(IPaper paper) {
		this.paper = paper;
	}


}
