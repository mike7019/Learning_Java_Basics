# AGENTS.md - Java Programming Learning Codebase

## Project Overview

This is an **educational Java learning project** organized by fundamental programming concepts. It's NOT a production application but a structured collection of examples demonstrating core Java principles. The primary application is a **Swing-based GUI calculator** (Calculadora.java).

**Project Structure by Learning Topics:**
- `tiposdedatos/` - Java primitive and non-primitive data types with constants vs. variables
- `operadores/` - All operator types (arithmetic, relational, logical, increment/decrement, assignment)
- `flujosdecontrol/` - Loop structures (for, while, do-while, for-each)
- `funciones/` - Function/method examples, including the main GUI calculator application
- `arrays/`, `estructurasdedatos/`, `poo/` - Placeholder directories for future content

## Build & Execution

**Build System:** Gradle with Java 17+ required

Key commands (Windows PowerShell):
```powershell
# Compile project
.\gradlew build

# Run specific classes (examples run from project root)
java -cp build\classes\java\main com.co.examples.funciones.Calculadora
java -cp build\classes\java\main com.co.examples.operadores.OperadoresAritmeticos
java -cp build\classes\java\main com.co.examples.tiposdedatos.TiposDeDatos

# Test framework (JUnit 5 configured but no tests currently exist)
.\gradlew test
```

**Key Observation:** Each Java file is a **standalone executable** with a `main()` method. There are no inter-class dependencies or shared libraries—code is intentionally self-contained for learning purposes.

## Code Patterns & Conventions

### 1. **File Naming & Organization**
- **Naming:** Spanish names describe the programming concept (e.g., `BucleFor` = For Loop, `OperadoresAritmeticos` = Arithmetic Operators)
- **Package Structure:** `com.co.examples.{topic}/{ConceptName}.java`
- **Comments:** Heavy inline Spanish comments explaining "what" and "why" for learners
  ```java
  // Example from TiposDeDatos.java
  /*
   * Tipos de datos primitivos
   * son aquellos que inician en minuscula y se muestran en azul, son primitivos de Java
   */
  static final int ENTERO = 10; //constante -> valor que no puede ser cambiado
  ```

### 2. **Main Method Pattern**
All classes use `public static void main(String[] args)` with simple console output or GUI initialization:
```java
// Console output examples
public static void main(String[] args) {
    System.out.println("El numero es: " + i);
}

// GUI examples use SwingUtilities
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new Calculadora().show());
}
```

### 3. **No External Dependencies**
- Uses only **Java standard library** (javax.swing for GUI, java.awt for layouts)
- No Mockito, Spring, or third-party libraries
- JUnit 5 is configured but **no test files exist**

### 4. **GUI Components (Calculadora.java)**
The main application demonstrates:
- Swing components: JFrame, JPanel, JButton, JTextField
- GridLayout for button arrangement (5x4 grid)
- Event listeners for calculator logic
- State management (currentValue, pendingOp, startNewNumber, errorState)

## Common Development Tasks

### Adding a New Learning Example
1. Create new `.java` file in appropriate topic folder: `src/main/java/com/co/examples/{topic}/`
2. Use package naming: `package com.co.examples.{topic};`
3. Add `public static void main(String[] args)` entry point
4. Include inline Spanish comments explaining the concept
5. Recompile: `.\gradlew build`
6. Run: `java -cp build\classes\java\main com.co.examples.{topic}.{ClassName}`

### Modifying the Calculator
Calculadora.java is 228 lines with core responsibilities:
- `show()` - Builds JFrame window
- `createButtonsPanel()` - Creates GridLayout button grid
- `handleInput(String input)` - Processes digit/operator/equals button presses
- `performOperation()` - Executes pending calculation

When modifying: restart with `.\gradlew build && java -cp build\classes\java\main com.co.examples.funciones.Calculadora`

## Important Notes for Agents

1. **No Architecture Complexity:** Each file is independent. There's no MVC, no dependency injection, no multi-tier architecture to understand.

2. **Spanish-First Codebase:** Variable names, class names, and comments are in Spanish. Maintain this convention when adding code.

3. **Educational Intent:** Code prioritizes **clarity and learning** over production practices. Don't suggest refactoring into factories, interfaces, or design patterns—examples are intentionally simple.

4. **Gradle Wrapper Usage:** Always use `.\gradlew` (Windows) rather than global gradle command to ensure consistency.

5. **Java 17+ Features Optional:** Project targets Java 17+ but uses basic syntax. Modern features (records, sealed classes, text blocks) are not employed.

6. **Empty Test Directory:** The `src/test/java` directory is empty. JUnit 5 is configured but no test infrastructure exists yet—this is normal for an educational project.

## Quick Reference: Class Entry Points

| Class | Location | Purpose |
|-------|----------|---------|
| Calculadora | funciones/ | Main GUI calculator (228 lines) |
| CalculadoraConFunciones | funciones/ | Console calculator with functions |
| TiposDeDatos | tiposdedatos/ | Demonstrates data types and constants |
| OperadoresAritmeticos | operadores/ | Arithmetic operators (+, -, *, /, %) |
| OperadoresRelacionales | operadores/ | Comparison operators (<, >, ==, !=, etc.) |
| OperadoresLogicos | operadores/ | Logical operators (&&, \|\|, !) |
| BucleFor | flujosdecontrol/ | For loop structure |
| BlucleWhile | flujosdecontrol/ | While loop structure |
| BucleDoWhile | flujosdecontrol/ | Do-while loop structure |

---

**Last Updated:** 2026-03-25 | **Language:** Spanish (code & comments) | **Target:** Java learners

