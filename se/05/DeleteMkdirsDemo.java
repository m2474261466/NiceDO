package day04;

import java.io.File;

/*
 * ɾ�����Ŀ¼��"�õݹ�ɾ��"
 */
public class DeleteMkdirsDemo {
	public static void main(String[] args){
		//ɾ�����Ŀ¼
		/*
		 * ������
		 * 1.ǰ����Ŀ¼��û�������ɾ��
		 * 2.�жϴ�Ŀ¼���������������������ļ���ֱ��ɾ��������Ŀ¼
		 * ������жϸ�Ŀ¼���Ƿ�������ֱ����Ŀ¼��û���κ������ɾ��
		 */
		File file=new File("./a");
		filesdelate(file);
	}

	private static void filesdelate(File file) {
		File[] files=file.listFiles();//��file����������
		for(int i=0;i<files.length;i++){//������Ŀ¼�����е�����
			if(files[i].isFile()){//�����file���ļ��Ļ�
				files[i].delete();//ɾ�����ļ�
				System.out.println("ɾ�����ļ���"+files[i].getName());
			}
			
			if(files[i].isDirectory()){//�����file��Ŀ¼�Ļ�
				filesdelate(files[i]);//�����Լ��ķ���filedelete��file��
				
			}
		}
		//�����file��û�������ֱ��ɾ��
		file.delete();
		System.out.println("ɾ��Ŀ¼��"+file.getName());
	}
}
