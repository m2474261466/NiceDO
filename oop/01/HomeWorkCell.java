package day01;

import java.util.Scanner;

public class HomeWorkCell {
	private int column;//列
	private int row;//行
	public HomeWorkCell(int column,int row){
		this.column=column;
		this.row=row;
	}
	
	//绘制图
	public void cell(){
		HomeWorkCell home=new HomeWorkCell(column,row);
		for(int i=0;i<20;i++){//行
			for(int j=0;j<10;j++){
				if(i==home.row && j==home.column){
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();//换行
		}
	}
	
	//向右移动一格
	public void rightStep(){
		//更新坐标
		column+=1;
		cell();//列先增加再进行绘制图
	}
	
	//向右移动n格
	public void rightStep(int n){
		//更新坐标
		column+=n;
		cell();//列先增加再进行绘制图
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		HomeWorkCell h=new HomeWorkCell(3,15);
		h.cell();
		System.out.println("功能1:向右移动1位,功能2:根据用户需要移动");
		int count=scanner.nextInt();
		switch (count) {
			case 1:
				h.rightStep();
				break;
			case 2:
				System.out.println("请输入移动的格数");
				int n=scanner.nextInt();
				h.rightStep(n);
				break;
			default:
				break;
		}
	}
	
}
