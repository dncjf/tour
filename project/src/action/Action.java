package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

//�� ��û�� ó���ϴ� Action Ŭ�������� ������ �����ϴ� �������̽�
public interface Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
