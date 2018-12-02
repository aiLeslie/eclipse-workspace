package com.leslie.javabase.chaper;

import com.leslie.javabase.chaper.iface.IPaper;
import com.leslie.javabase.chaper.iface.IInkBox;
/**
 * 打印机类 - 使用标准的黑盒和纸张进行打印
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
			System.out.println("黑盒没有安装成功~");
			
		}
		if(paper == null) {
			System.out.println("纸张没有安装成功~");
			
			
		}
		else {
			System.out.println("以下文字颜色为" + inkbox.getColor());
			System.out.println("纸张大小为" + paper.getSize());
		    System.out.println("打印内容为" + concent);
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
