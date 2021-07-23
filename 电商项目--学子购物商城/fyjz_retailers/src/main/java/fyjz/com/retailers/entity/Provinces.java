package fyjz.com.retailers.entity;

import java.io.Serializable;

/**
 * 省份实体类
 * @author Lenovo
 *
 */
public class Provinces implements Serializable{
    private Integer id;

    private String provinceCode;

    private String provinceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

	public Provinces() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provinces(Integer id, String provinceCode, String provinceName) {
		super();
		this.id = id;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((provinceCode == null) ? 0 : provinceCode.hashCode());
		result = prime * result + ((provinceName == null) ? 0 : provinceName.hashCode());
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
		Provinces other = (Provinces) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (provinceCode == null) {
			if (other.provinceCode != null)
				return false;
		} else if (!provinceCode.equals(other.provinceCode))
			return false;
		if (provinceName == null) {
			if (other.provinceName != null)
				return false;
		} else if (!provinceName.equals(other.provinceName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Provinces [id=" + id + ", provinceCode=" + provinceCode + ", provinceName=" + provinceName + "]";
	}
    
}