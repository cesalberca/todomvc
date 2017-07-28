package com.autentia.training.selenium.todomvc.main;

final class TodoMvcFlow {

    private final TodoMvcPage page;

    TodoMvcFlow(TodoMvcPage page) {
        this.page = page;
    }

    void createTodo(String todo) {
        page
                .typeTodo(todo)
                .enterNewTodo();
    }

    void editTodo(int index, String newName) {
        page
                .makeTodoEditable(index)
                .clearTodo()
                .editTodo(newName)
                .submitEditedTodo();
    }

    void deleteTodo(int index) {
        page
                .makeTodoDeleteable(index)
                .deleteTodo();
    }

    void completeTodo(int index) {
        page
                .clickToggleTodo(index);
    }

    void filterActiveTodos() {
        page
                .clickActiveFilterTodos();
    }

    void filterCompletedTodos() {
        page
                .clickCompletedFilterTodos();
    }

    void clearCompletedTodos() {
        page
                .clickClearCompletedTodos();
    }

}
