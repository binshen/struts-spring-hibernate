package com.moral.dao;

import com.moral.model.Todo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bin.shen on 20/10/2016.
 */

@Repository("todoDao")
public class TodoDaoImpl implements TodoDao {

    @Autowired
    protected HibernateTemplate template;

    public List<Todo> selectTodoList() {
        return (List<Todo>) template.find("from Todo");
    }

    public Todo selectTodo(final int id) {
//        return template.execute((Session session)-> {
//            String hql = "from Todo where id=?";
//            Query query = session.createQuery(hql);
//            query.setParameter(0, id);
//            return query.uniqueResult();
//        });

        return (Todo) template.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql = "from Todo where id = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0, id);
                return query.uniqueResult();
            }
        });
    }

    public int insertTodo(Todo todo) {
        template.save(todo);
        return 1;
    }

    public int deleteTodo(Todo todo) {
        template.delete(todo);
        return 1;
    }

    public int updateTitle(Todo todo) {
        template.saveOrUpdate(todo);
        return 1;
    }

    public int updateStatus(Todo todo) {
        template.saveOrUpdate(todo);
        return 1;
    }
}
