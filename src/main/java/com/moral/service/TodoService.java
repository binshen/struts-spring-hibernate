package com.moral.service;


import com.moral.dao.TodoDao;
import com.moral.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("todoService")
public class TodoService {

    @Autowired
    @Qualifier("todoDao")
    private TodoDao todoDao;

    public List<Todo> selectTodoList() {
        return todoDao.selectTodoList();
    }

    public Todo selectTodo(int id) {
        return todoDao.selectTodo(id);
    }

    public int insertTodo(Todo todo) {
        return todoDao.insertTodo(todo);
    }

    public int deleteTodo(Todo todo) {
        return todoDao.deleteTodo(todo);
    }

    public int updateTitle(Todo todo) {
        return todoDao.updateTitle(todo);
    }

    public int updateStatus(Todo todo) {
        return todoDao.updateStatus(todo);
    }
}
