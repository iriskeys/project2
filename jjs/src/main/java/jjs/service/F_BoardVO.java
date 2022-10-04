package jjs.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class F_BoardVO {

	private int FBoardNo;
	private String userId;
	private String FTitle;
	private String FContent;
	private String FCreateDate;
	private String FBoardType;

	public F_BoardVO(int FBoardNo, String userId, String FTitle, String FContent, String FCreateDate,
			String F_BoardType) {

		this.FBoardNo = FBoardNo;
		this.userId = userId;
		this.FTitle = FTitle;
		this.FContent = FContent;
		this.FCreateDate = FCreateDate;
		this.FBoardType = F_BoardType;
	}

}
