package fyjz.com.retailers.commons;

import java.io.Serializable;
/**
 * ��װ��ҳ��Ϣ
 * @author Lenovo
 *
 */
public class PageObject implements Serializable{
	// ��ǰҳ����Ĭ�ϵ�ǰҳ��Ϊ��1ҳ��
	private Integer pageCurrent = 1;
	// ��¼���������ж��������ݣ�
	private Integer rowCount;
	// ÿҳ��ʾ�ļ�¼�������ݵ�������
	private Integer pageSize = 8;
	// ��ҳ��
	private Integer pageCount;
	// ��ȡ��ҳ����ʼҳ
	private Integer startIndex;
	
	// ��ȡ��ҳ����ʼҳ����ʼҳ = (��ǰҳ��-1)*ÿҳ��ʾ�ļ�¼����
	public Integer getStartIndex() {
		int start = (pageCurrent - 1)*pageSize;
		return start;
	}
	// ��ȡ��ҳ������ҳ�� = (��¼��/ÿҳ��ʾ�ļ�¼��)��
	public Integer getPageCount() {
		int pages = rowCount % pageSize == 0 ? rowCount/pageSize : rowCount/pageSize+1;
		return pages;
	}
	public PageObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageObject(Integer pageCurrent, Integer rowCount, Integer pageSize, Integer pageCount, Integer startIndex) {
		super();
		this.pageCurrent = pageCurrent;
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.startIndex = startIndex;
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pageCount == null) ? 0 : pageCount.hashCode());
		result = prime * result + ((pageCurrent == null) ? 0 : pageCurrent.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((rowCount == null) ? 0 : rowCount.hashCode());
		result = prime * result + ((startIndex == null) ? 0 : startIndex.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageObject other = (PageObject) obj;
		if (pageCount == null) {
			if (other.pageCount != null)
				return false;
		} else if (!pageCount.equals(other.pageCount))
			return false;
		if (pageCurrent == null) {
			if (other.pageCurrent != null)
				return false;
		} else if (!pageCurrent.equals(other.pageCurrent))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (rowCount == null) {
			if (other.rowCount != null)
				return false;
		} else if (!rowCount.equals(other.rowCount))
			return false;
		if (startIndex == null) {
			if (other.startIndex != null)
				return false;
		} else if (!startIndex.equals(other.startIndex))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", rowCount=" + rowCount + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", startIndex=" + startIndex + "]";
	}
	
}
