package entity;

import java.io.Serializable;

/**
 * 用户的实体化
 * @author 24742
 *
 */
public class User implements Serializable {
          private int id;//用户id
          private String userName;//账号
          private String userPwd;//密码
          private String userEmail;//邮箱
          private String userPhone;//电话
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserPwd() {
			return userPwd;
		}
		public void setUserPwd(String userPwd) {
			this.userPwd = userPwd;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserPhone() {
			return userPhone;
		}
		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
			result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
			result = prime * result + ((userPwd == null) ? 0 : userPwd.hashCode());
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
			User other = (User) obj;
			if (id != other.id)
				return false;
			if (userEmail == null) {
				if (other.userEmail != null)
					return false;
			} else if (!userEmail.equals(other.userEmail))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			if (userPhone == null) {
				if (other.userPhone != null)
					return false;
			} else if (!userPhone.equals(other.userPhone))
				return false;
			if (userPwd == null) {
				if (other.userPwd != null)
					return false;
			} else if (!userPwd.equals(other.userPwd))
				return false;
			return true;
		}
		public User(int id, String userName, String userPwd, String userEmail, String userPhone) {
			super();
			this.id = id;
			this.userName = userName;
			this.userPwd = userPwd;
			this.userEmail = userEmail;
			this.userPhone = userPhone;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail
					+ ", userPhone=" + userPhone + "]";
		}
	
		
          
}
