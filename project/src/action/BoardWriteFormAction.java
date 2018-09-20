package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import vo.ReplyInfo;

public class BoardWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
			int num=0,ref=1,re_step=0,re_level=0;
		  //사용자가 답변하기 를 요청했을 때 파라미터로 전송됨
		  
		    if(request.getParameter("num")!=null){
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			re_level=Integer.parseInt(request.getParameter("re_level"));
			
		    }
		    
		    ReplyInfo replyInfo = new ReplyInfo();
		    replyInfo.setNum(num);
		    replyInfo.setRe_level(re_level);
		    replyInfo.setRe_step(re_step);
		    replyInfo.setRef(ref);
		    
		    request.setAttribute("replyInfo", replyInfo);
		    request.setAttribute("inc_page", "/board/writeForm.jsp");
		    ActionForward forward =  new ActionForward();
		    
		    forward.setUrl("layoutTempate.jsp");
		    
		    
		    
		return forward;
	}

}
