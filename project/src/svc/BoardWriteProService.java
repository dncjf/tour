package svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardVO;
public class BoardWriteProService {

	public boolean writeArticle(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boolean writeSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int insertCount = boardDAO.insertArticle(boardVO);
		if(insertCount > 0) {
			writeSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);
		return writeSuccess;
	}

}







