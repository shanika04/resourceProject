package ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.directory.DirContext;
import javax.servlet.http.HttpServletRequest;

public class LDAPTest2 {

  public boolean test(HttpServletRequest request, DirContext ctx) throws NamingException {
    String pass = request.getParameter("pass");
    String user = "guest";

    String filter = "(&(uid=" + user + ")(userPassword=" + "{0}" + "))";

    NamingEnumeration<SearchResult> results =
        ctx.search("ou=system", filter, new String[] {pass}, new SearchControls());
    return results.hasMore();
  }
}
