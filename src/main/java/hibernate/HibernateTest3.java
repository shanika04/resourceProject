package hibernate;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HibernateTest3 {
    @PostMapping("/hibernateTest1")
    public void hibernateTest3(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String hql = "UPDATE Employee set salary = 100 WHERE id = " + id + " AND name = " + name;
        Query query = session.createQuery(hql);
        session.getTransaction().commit();
        session.close();
    }
}