package cn.bin.javabase.chapter3;
/**
 * 
* ��Ŀ���ƣ�BinWork   
* �����ƣ�LuckyNumber   
* ��������
* �����ˣ������   
* ����ʱ�䣺2017��10��15�� ����3:30:07   
* @version 1.0
* ������һ����λ�����У���������ĸ�λ��
* �Ͱ�λ��֮�ʹ���16������ʮλ����ǧλ��
* ֮��С��3���ͳ�������Ϊ���Ͼ�����������
* ��С����̼������1000~9999�У�һ��
* �ж��ٸ������Ͼ�����������λ�����أ���
* ӡ�����յĸ�����
 */
public class LuckyNumber {

	
	public static void main (String []args) {
		int count = 0;
		System.out.println("�������б�����");

		for(int i = 1000; i < 10000;i++) 
		{
			if (i % 10 + i / 100 % 10 > 16 && i / 10 % 10 + i / 1000 % 10 < 3) {
				count++;
				if((count - 1) % 3 == 0)System.out.println();
				System.out.print(i + "\t");
				
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("һ����" + count + "��������");
	}
}
