package com.association.security;

import java.io.Serializable;

public class LoginResponse implements Serializable {
 
		private static final long serialVersionUID = 1L;
		private String token;
		private String username;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public LoginResponse() {
			super();
		}

		public LoginResponse(String token, String username) {
			super();
			this.token = token;
			this.username = username;
		}

		@Override
		public String toString() {
			return "LoginResponse [token=" + token + ", username=" + username + "]";
		}


}
