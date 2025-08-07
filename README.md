# Budget Manager

Simple JavaFX application for tracking personal expenses and income with a daily spending suggestion.

## Features
- Add expenses with amount, description, category, and date.
- Add income entries with amount, description, and date.
- View all records in a table.
- Dynamic daily spending suggestion based on current month data.

## Running
The project uses Java and JavaFX. Compile with:

```
javac --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml -d out src/budget/*.java
java --module-path /usr/share/openjfx/lib:out --add-modules javafx.controls,javafx.fxml budget.Main
```

This project stores data in memory only.
