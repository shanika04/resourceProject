package ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.directory.DirContext;
import javax.servlet.http.HttpServletRequest;

public class LDAPTest4 {

  public boolean test(HttpServletRequest request, DirContext ctx) throws NamingException {
    String pass = request.getParameter("pass");
    String user = request.getParameter("user");
    user = user + "_USER";
    String saltedPassword = pass + "%!";
    String filter = "(&(uid=" + "{0}" + ")(userPassword=" + saltedPassword + "))";

    NamingEnumeration<SearchResult> results =
        ctx.search("ou=system", filter, new String[] {user}, new SearchControls());
    return results.hasMore();
  }
}
