package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.BoardVO;
import vo.PageInfo;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pageSize = 10;
	//  한 페이지 당 출력될 글의 개수
		
		String pageNum = request.getParameter("pageNum");
	    if (pageNum == null) {
	        pageNum = "1";
	    }

	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize + 1;
	    //해당 페이지에 처음으로 출력될 레코드 번호
	    //현재 페이지 2
	    //(2 - 1) * 10 + 1   ---> 11
	    int count = 0;
	    //전체 글의 개수
	    int number=0;
	    //해당 페이지에 출력되는 첫번째 글의 번호

	    List<BoardVO> articleList = null;
	    //해당 페이지에 출력될 글목록을 저장한 컬렉션
	    
	    BoardListService boardListService
	    = new BoardListService();
	    
	    count = boardListService.getArticleCount();
	    if (count > 0) {
	        articleList = boardListService.getArticles(startRow, pageSize);
	    }

		number=count-(currentPage-1)*pageSize;
		//총 글 : 132
		//현재 페이지 : 1
		//132 - ( 1 - 1) * 10    ----> 132
		//현재페이지 : 2
		//132 - (2 - 1) * 10 ---->122
		int startPage = 0;
		int endPage = 0;
		int pageCount = 0;
		if (count > 0) {
	        pageCount = count / pageSize + 
	        		( count % pageSize == 0 ? 0 : 1);
			 
	        startPage = (int)((currentPage - 1)/10)*10+1;
			int pageBlock=10;
	        endPage = startPage + pageBlock-1;
	        if (endPage > pageCount) endPage = pageCount;
	        
		}
		
		request.setAttribute("articleList", articleList);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCount(count);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setNumber(number);
		pageInfo.setPageCount(pageCount);
		pageInfo.setStartPage(startPage);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("inc_page", "/board/list.jsp");
	    ActionForward forward =  new ActionForward();
	    
	    forward.setUrl("layoutTempate.jsp");
		return forward;
	}

}








