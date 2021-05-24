package com.tunix.restApp.repository.Impl;

import com.tunix.restApp.model.User;
import com.tunix.restApp.repository.UserRepository;
import com.tunix.restApp.util.SessionUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserImplRepository implements UserRepository {
    private SessionUtil sessionUtil = new SessionUtil();
    @Override
    public List<User> getAll(){
        List<User> userList = null;
        try(Session session = sessionUtil.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
            criteriaQuery.from(User.class);
            userList = session.createQuery(criteriaQuery).getResultList();
        }
        return userList;
    }
    @Override
    public User getById(Long id) {
        User user = null;
        try (Session session = sessionUtil.openSession()){
            user = session.load(User.class, id);
        }
        return user;
    }
    @Override
    public User save(User user) {
        try (Session session = sessionUtil.openTransactionSession()) {
            session.save(user);
            session.getTransaction().commit();
            return user;
        }
    }
    @Override
    public User update(User User) {
        try (Session session = sessionUtil.openTransactionSession()) {
            session.update(User);
            session.getTransaction().commit();
        }
        return User;
    }
    @Override
    public void deleteById(Long id) {
        try (Session session = sessionUtil.openTransactionSession()) {
            User User = session.load(User.class, id);
            session.delete(User);
            session.getTransaction().commit();
        }

    }
}
