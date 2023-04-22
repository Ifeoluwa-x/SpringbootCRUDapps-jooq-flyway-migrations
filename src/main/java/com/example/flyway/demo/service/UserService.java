package com.example.flyway.demo.service;


import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Todo;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.jooq.impl.DSL.*;

import java.util.List;

@Service
public class UserService {
    private DSLContext dslContext;
    @Autowired
    public UserService(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public void insertTodo(Todo todo) {
        dslContext.insertInto(Tables.TODO, Tables.TODO.TASKNAME, Tables.TODO.TASKDESCRIPTION)
                .values(todo.getTaskname(), todo.getTaskdescription())
                .execute();
    }

    public List<Todo> getTodo() {
        return dslContext.selectFrom(Tables.TODO)
                .fetchInto(Todo.class);
    }

    public void deleteTodoById(int id) {
        dslContext.deleteFrom(Tables.TODO)
                .where(Tables.TODO.ID.eq(ULong.valueOf(id)))
                .execute();
    }

    public void updateTodoById(int id, String newTaskName, String newTaskDescription) {
        dslContext.update(Tables.TODO)
                .set(Tables.TODO.TASKNAME, newTaskName)
                .set(Tables.TODO.TASKDESCRIPTION, newTaskDescription)
                .where(Tables.TODO.ID.eq(ULong.valueOf(id)))
                .execute();
    }
}
