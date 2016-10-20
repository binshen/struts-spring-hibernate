package com.moral.controller;

import com.moral.model.Todo;
import com.moral.service.TodoService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


public class TodoController extends ActionSupport implements ServletRequestAware {

    public List<Todo> todoList;
    public Todo todo;
    public String site_name = "TODO List";

    private HttpServletRequest request;

    @Autowired
    TodoService todoService;

    public String index() {
        todoList = todoService.selectTodoList();
        return "index";
    }

    public String add() {
        Todo todo = new Todo();
        todo.setTitle(request.getParameter("title"));
        todo.setPost_date(new Date());
        todo.setFinished(0);
        todoService.insertTodo(todo);
        return "add";
    }

    public String edit() {
        todo = todoService.selectTodo(Integer.valueOf(request.getParameter("id")));
        return "edit";
    }

    public String save() {
        Todo todo = todoService.selectTodo(Integer.valueOf(request.getParameter("id")));
        todo.setTitle(request.getParameter("title"));
        todoService.updateTitle(todo);
        return "save";
    }

    public String delete() {
        Todo todo = todoService.selectTodo(Integer.valueOf(request.getParameter("id")));
        todoService.deleteTodo(todo);
        return "delete";
    }

    public String finish() {
        Todo todo = todoService.selectTodo(Integer.valueOf(request.getParameter("id")));
        todo.setFinished(Integer.valueOf(request.getParameter("status")));
        todoService.updateStatus(todo);
        return "finish";
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}
