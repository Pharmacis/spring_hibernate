package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      try (Session session = sessionFactory.openSession ()) {
         session.save (user);
      } catch (Exception ex) {
         ex.printStackTrace ();
      }
      //sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      try (Session session = sessionFactory.openSession ()) {
         TypedQuery<User> query = session.createQuery ("from User");
         return query.getResultList ();
      } catch (Exception ex) {
         ex.printStackTrace ();
      }
      // TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      // return query.getResultList()
      return null;
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(Long idCar, int seriesCar) {
      try (Session session = sessionFactory.openSession ()) {
         Query<User> query = session.createQuery ("from User u where u.car.id = :idCar and u.car.series = :seriesCar");
         User user = query.setParameter ("idCar", idCar)
                 .setParameter ("seriesCar", seriesCar)
                 .getSingleResult ();
         return user;
      } catch (Exception ex) {
         ex.printStackTrace ();
      }
      return null;
   }
}
