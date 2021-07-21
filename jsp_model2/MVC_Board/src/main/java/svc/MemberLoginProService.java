package svc;

import java.sql.Connection;

import dao.MemberDAO;
import vo.LoginFailException;

import static db.JdbcUtil.*;

public class MemberLoginProService {

   public boolean login(String id, String password) throws LoginFailException {
      boolean isLoginSuccess = false;
      
      Connection con = getConnection();
      MemberDAO memberDAO = MemberDAO.getInstance();
      memberDAO.setConnection(con);
      
      isLoginSuccess = memberDAO.selectLoginMember(id, password);
      
      close(con);
      
      return isLoginSuccess;
   }

}












