package com.moral.dao;

import com.moral.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("todoDao")
public interface TodoDao {

    public List<Todo> selectTodoList();

    public Todo selectTodo(int id);

    public int insertTodo(Todo todo);

    public int deleteTodo(Todo todo);

    public int updateTodo(Todo todo);
}
