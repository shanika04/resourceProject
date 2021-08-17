package hibernate;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HibernateTest2 {
  @PostMapping("/hibernateTest2")
  public void hibernateTest2(HttpServletRequest request) {
    String id = request.getParameter("id");
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    Query query = session.createQuery("UPDATE Employee set salary = 100 WHERE id = " + id);
    session.getTransaction().commit();
    session.close();
  }
}