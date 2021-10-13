package com.devtopia.user;

	public class UserVO {

		private String userId;
		private String userPw;
		private String userName;
		private String email;
		private String nickName;
		private int phoneNumber;
		private String address;
		
					
		public String getUserId() {
			return userId;
		}


		public void setUserId(String userId) {
			this.userId = userId;
		}


		public String getUserPw() {
			return userPw;
		}


		public void setUserPw(String userPw) {
			this.userPw = userPw;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getNickName() {
			return nickName;
		}


		public void setNickName(String nickName) {
			this.nickName = nickName;
		}


		public int getPhoneNumber() {
			return phoneNumber;
		}


		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		@Override
		public String toString() {
			return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", email=" + email
					+ ", nickName=" + nickName + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
		}
		
		
		
		
		
	}

