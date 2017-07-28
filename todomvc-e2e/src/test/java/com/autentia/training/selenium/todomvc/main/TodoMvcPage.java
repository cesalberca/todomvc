package com.autentia.training.selenium.todomvc.main;

import com.autentia.training.selenium.todomvc.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

final class TodoMvcPage extends BasePage {

    private final By inputNewTodo = By.cssSelector(".new-todo");
    private final By todos = By.cssSelector(".todo-list > li > .view > label");
    private final By completedTodos = By.cssSelector(".todo-list > li.completed > .view > label");
    private final By toggleButton = By.cssSelector(".toggle");
    private final By filterActiveButton = By.cssSelector("a[href=\"#/active\"]");
    private final By filterCompletedButton = By.cssSelector("a[href=\"#/completed\"]");
    private final By filterClearCompletedButton = By.cssSelector(".clear-completed");

    private WebElement activeTodoEditInput;
    private WebElement activeTodoDeleteButton;

    TodoMvcPage(WebDriver driver) {
        super(driver);
        visit("/");
    }

    private List<WebElement> findTodos() {
        return findAll(todos);
    }

    private List<WebElement> findCompletedTodos() {
        return findAll(completedTodos);
    }

    private WebElement findNewTodoButton() {
        final Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inputNewTodo));
    }

    private WebElement findTodo(int index) {
        // Indexes in CSS start at 1
        final int cssIndex = index + 1;
        return find(By.cssSelector(".todo-list > li:nth-child(" + cssIndex + ')'));
    }

    private WebElement findActiveTodoDeleteButton(int index) {
        return findTodo(index).findElement(By.cssSelector(".destroy"));
    }

    private WebElement findActiveTodoEditInput(int index) {
        final Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5);
        final WebElement activeTodoEditInput = findTodo(index).findElement(By.cssSelector("input:not([type=checkbox])"));
        return wait.until(ExpectedConditions.elementToBeClickable(activeTodoEditInput));
    }

    List<String> getActiveTodosText() {
        return findTodos().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    List<String> getCompletedTodos() {
        return findCompletedTodos().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    TodoMvcPage typeTodo(String todo) {
        findNewTodoButton().sendKeys(todo);
        return this;
    }

    TodoMvcPage enterNewTodo() {
        findNewTodoButton().sendKeys(Keys.ENTER);
        return this;
    }

    TodoMvcPage makeTodoEditable(int index) {
        final Actions action = new Actions(getDriver());
        final WebElement todoToBeEdited = findTodo(index);

        action.moveToElement(todoToBeEdited).doubleClick().perform();

        activeTodoEditInput = findActiveTodoEditInput(index);
        return this;
    }

    TodoMvcPage clearTodo() {
        // Cache the length, as Selenium looks for the DOM
        final int length = activeTodoEditInput.getAttribute("value").length();
        for (int i = 0; i < length; i++) {
            activeTodoEditInput.sendKeys(Keys.BACK_SPACE);
        }
        return this;
    }

    TodoMvcPage editTodo(String newName) {
        activeTodoEditInput.sendKeys(newName);
        return this;
    }

    TodoMvcPage submitEditedTodo() {
        activeTodoEditInput.sendKeys(Keys.ENTER);
        activeTodoEditInput = null;
        return this;
    }

    TodoMvcPage makeTodoDeleteable(int index) {
        final Actions actions = new Actions(getDriver());
        final WebElement todoToBeDeleted = findTodo(index);

        actions.moveToElement(todoToBeDeleted).perform();
        activeTodoDeleteButton = findActiveTodoDeleteButton(index);

        return this;
    }

    TodoMvcPage deleteTodo() {
        activeTodoDeleteButton.click();
        activeTodoDeleteButton = null;
        return this;
    }

    TodoMvcPage clickToggleTodo(int index) {
        findTodo(index).findElement(toggleButton).click();
        return this;
    }

    TodoMvcPage clickActiveFilterTodos() {
        find(filterActiveButton).click();
        return this;
    }

    TodoMvcPage clickCompletedFilterTodos() {
        find(filterCompletedButton).click();
        return this;
    }

    TodoMvcPage clickClearCompletedTodos() {
        find(filterClearCompletedButton).click();
        return this;
    }

}
