import com.model.Role;
import com.model.TimeEx;
import com.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.sql.Time;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by User on 29.06.2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
//            session.beginTransaction();
//            User user = new User();
//            user.setId(3);
//            user.setUsername("danil");
//            user.setPassword("2000");
//            Role role = (Role) session.load(Role.class, new Integer(2));
//            Set<Role> roles = new HashSet<>();
//            roles.add(role);
//            user.setRoles(roles);
//            session.save(user);
//            session.getTransaction().commit();

//            session.beginTransaction();
//            TimeEx timeEx = new TimeEx();
//            Time time = new Time(10, 20, 30);
//            timeEx.setTime(time);
//            session.save(timeEx);
//            session.getTransaction().commit();

//            session.beginTransaction();
//            TimeEx timeEx = (TimeEx) session.load(TimeEx.class, new Integer(1));
//            System.out.println(timeEx.getTime());
//            session.getTransaction().commit();

//            session.beginTransaction();
//            Query query = session.createQuery("delete from TimeEx where time=:t");
//            TimeEx timeEx = new TimeEx();
//            Time time = new Time(11, 05, 59);
//            timeEx.setTime(time);
//            query.setParameter("t", timeEx.getTime());
//            int resoult = query.executeUpdate();
//            System.out.println(resoult);
////          query.setParameter("t", timeEx.getTime());
////          List<TimeEx> list = query.list();
//            session.getTransaction().commit();

//            session.beginTransaction();
//            Role role = (Role) session.load(Role.class, new Integer(1));
//            role.setRole("user");
//            session.update(role);
//            User user = (User) session.load(User.class, new Integer(1));
//            user.setUsername("user21");
//            session.update(user);
//            session.getTransaction().commit();

            session.beginTransaction();
            User user = (User) session.load(User.class, new Integer(1));
            for (Role r: user.getRoles()){
                System.out.println(r.getRole());
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}