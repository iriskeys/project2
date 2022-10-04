package jjs.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class L_BoardVO {

	private int LBoardNo;
	private String userId;
	private String LTitle;
	private String LContent;
	private String LCreateDate;
	private String LBoardType;
	
	public L_BoardVO(int LBoardNo, String userId, String LTitle, String LContent, String LCreateDate,
			String LBoardType) {
		
		this.LBoardNo = LBoardNo;
		this.userId = userId;
		this.LTitle = LTitle;
		this.LContent = LContent;
		this.LCreateDate = LCreateDate;
		this.LBoardType = LBoardType;
	}
	
}
