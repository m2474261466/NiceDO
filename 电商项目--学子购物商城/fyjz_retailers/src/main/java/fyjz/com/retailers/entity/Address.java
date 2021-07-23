package fyjz.com.retailers.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 收货地址实体类
 * @author Lenovo
 *
 */
public class Address implements Serializable{
    private Integer id;

    private Integer uid;

    private String recvUsername;

    private String recvProvincecode;

    private String recvCitycode;

    private String recvAreacode;

    private String recvDistrict;

    private String recvAddress;

    private String recvPhone;

    private String recvTel;

    private String recvZip;

    private String recvTag;

    private Integer isDefault;

    private String createUser;

    private Date createTime;

    private String modifiedUser;

    private Date modifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRecvUsername() {
        return recvUsername;
    }

    public void setRecvUsername(String recvUsername) {
        this.recvUsername = recvUsername == null ? null : recvUsername.trim();
    }

    public String getRecvProvincecode() {
        return recvProvincecode;
    }

    public void setRecvProvincecode(String recvProvincecode) {
        this.recvProvincecode = recvProvincecode == null ? null : recvProvincecode.trim();
    }

    public String getRecvCitycode() {
        return recvCitycode;
    }

    public void setRecvCitycode(String recvCitycode) {
        this.recvCitycode = recvCitycode == null ? null : recvCitycode.trim();
    }

    public String getRecvAreacode() {
        return recvAreacode;
    }

    public void setRecvAreacode(String recvAreacode) {
        this.recvAreacode = recvAreacode == null ? null : recvAreacode.trim();
    }

    public String getRecvDistrict() {
        return recvDistrict;
    }

    public void setRecvDistrict(String recvDistrict) {
        this.recvDistrict = recvDistrict == null ? null : recvDistrict.trim();
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress == null ? null : recvAddress.trim();
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone == null ? null : recvPhone.trim();
    }

    public String getRecvTel() {
        return recvTel;
    }

    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel == null ? null : recvTel.trim();
    }

    public String getRecvZip() {
        return recvZip;
    }

    public void setRecvZip(String recvZip) {
        this.recvZip = recvZip == null ? null : recvZip.trim();
    }

    public String getRecvTag() {
        return recvTag;
    }

    public void setRecvTag(String recvTag) {
        this.recvTag = recvTag == null ? null : recvTag.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Integer id, Integer uid, String recvUsername, String recvProvincecode, String recvCitycode,
			String recvAreacode, String recvDistrict, String recvAddress, String recvPhone, String recvTel,
			String recvZip, String recvTag, Integer isDefault, String createUser, Date createTime, String modifiedUser,
			Date modifiedTime) {
		super();
		this.id = id;
		this.uid = uid;
		this.recvUsername = recvUsername;
		this.recvProvincecode = recvProvincecode;
		this.recvCitycode = recvCitycode;
		this.recvAreacode = recvAreacode;
		this.recvDistrict = recvDistrict;
		this.recvAddress = recvAddress;
		this.recvPhone = recvPhone;
		this.recvTel = recvTel;
		this.recvZip = recvZip;
		this.recvTag = recvTag;
		this.isDefault = isDefault;
		this.createUser = createUser;
		this.createTime = createTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
		result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
		result = prime * result + ((recvAddress == null) ? 0 : recvAddress.hashCode());
		result = prime * result + ((recvAreacode == null) ? 0 : recvAreacode.hashCode());
		result = prime * result + ((recvCitycode == null) ? 0 : recvCitycode.hashCode());
		result = prime * result + ((recvDistrict == null) ? 0 : recvDistrict.hashCode());
		result = prime * result + ((recvPhone == null) ? 0 : recvPhone.hashCode());
		result = prime * result + ((recvProvincecode == null) ? 0 : recvProvincecode.hashCode());
		result = prime * result + ((recvTag == null) ? 0 : recvTag.hashCode());
		result = prime * result + ((recvTel == null) ? 0 : recvTel.hashCode());
		result = prime * result + ((recvUsername == null) ? 0 : recvUsername.hashCode());
		result = prime * result + ((recvZip == null) ? 0 : recvZip.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
		Address other = (Address) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		if (modifiedUser == null) {
			if (other.modifiedUser != null)
				return false;
		} else if (!modifiedUser.equals(other.modifiedUser))
			return false;
		if (recvAddress == null) {
			if (other.recvAddress != null)
				return false;
		} else if (!recvAddress.equals(other.recvAddress))
			return false;
		if (recvAreacode == null) {
			if (other.recvAreacode != null)
				return false;
		} else if (!recvAreacode.equals(other.recvAreacode))
			return false;
		if (recvCitycode == null) {
			if (other.recvCitycode != null)
				return false;
		} else if (!recvCitycode.equals(other.recvCitycode))
			return false;
		if (recvDistrict == null) {
			if (other.recvDistrict != null)
				return false;
		} else if (!recvDistrict.equals(other.recvDistrict))
			return false;
		if (recvPhone == null) {
			if (other.recvPhone != null)
				return false;
		} else if (!recvPhone.equals(other.recvPhone))
			return false;
		if (recvProvincecode == null) {
			if (other.recvProvincecode != null)
				return false;
		} else if (!recvProvincecode.equals(other.recvProvincecode))
			return false;
		if (recvTag == null) {
			if (other.recvTag != null)
				return false;
		} else if (!recvTag.equals(other.recvTag))
			return false;
		if (recvTel == null) {
			if (other.recvTel != null)
				return false;
		} else if (!recvTel.equals(other.recvTel))
			return false;
		if (recvUsername == null) {
			if (other.recvUsername != null)
				return false;
		} else if (!recvUsername.equals(other.recvUsername))
			return false;
		if (recvZip == null) {
			if (other.recvZip != null)
				return false;
		} else if (!recvZip.equals(other.recvZip))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", recvUsername=" + recvUsername + ", recvProvincecode="
				+ recvProvincecode + ", recvCitycode=" + recvCitycode + ", recvAreacode=" + recvAreacode
				+ ", recvDistrict=" + recvDistrict + ", recvAddress=" + recvAddress + ", recvPhone=" + recvPhone
				+ ", recvTel=" + recvTel + ", recvZip=" + recvZip + ", recvTag=" + recvTag + ", isDefault=" + isDefault
				+ ", createUser=" + createUser + ", createTime=" + createTime + ", modifiedUser=" + modifiedUser
				+ ", modifiedTime=" + modifiedTime + "]";
	}
    
}