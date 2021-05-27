package day01;

import java.util.Scanner;

public class HomeWorkCell {
	private int column;//��
	private int row;//��
	public HomeWorkCell(int column,int row){
		this.column=column;
		this.row=row;
	}
	
	//����ͼ
	public void cell(){
		HomeWorkCell home=new HomeWorkCell(column,row);
		for(int i=0;i<20;i++){//��
			for(int j=0;j<10;j++){
				if(i==home.row && j==home.column){
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();//����
		}
	}
	
	//�����ƶ�һ��
	public void rightStep(){
		//��������
		column+=1;
		cell();//���������ٽ��л���ͼ
	}
	
	//�����ƶ�n��
	public void rightStep(int n){
		//��������
		column+=n;
		cell();//���������ٽ��л���ͼ
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		HomeWorkCell h=new HomeWorkCell(3,15);
		h.cell();
		System.out.println("����1:�����ƶ�1λ,����2:�����û���Ҫ�ƶ�");
		int count=scanner.nextInt();
		switch (count) {
			case 1:
				h.rightStep();
				break;
			case 2:
				System.out.println("�������ƶ��ĸ���");
				int n=scanner.nextInt();
				h.rightStep(n);
				break;
			default:
				break;
		}
	}
	
}
