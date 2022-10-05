package jjs.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO {

	private String userId;
	private String userPw;
	private String userName;
	private String userNickname;
	private String userPhone;
	private String userEmail;
	private String userRole;
	private String createDate;
	
	public UserVO(String userId, String userPw, String userName, String userNickname, String userPhone, String userEmail, String userRole,
			String createDate) {
		
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.createDate = createDate;
	}
	
	
}
