package jjs.service;

public interface UserDAO {

	void insertUser(UserVO userVO) throws Exception;
	
	int loginUser(UserVO userVO)throws Exception;
	
	void deleteUser(UserVO userVO)throws Exception;
	
	int idCheck(String userId)throws Exception;
	
}
