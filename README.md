# Data Structures – TD

**ENSET – Année universitaire 2025/2026**  
**2ème année : GLSID**  
**Module : Structures de données**  
**Encadrant : Pr. M. QBADOU**

This repository contains solutions for the **Data Structures TD**.  
The objective is to practice **data structures, algorithms, and complexity analysis**.

---

## 📘 Exercises Overview

### Exercice 1 – List Validation
- Given a list `L` of `N` integers.
- Verify that:
  - All elements belong to the interval `[1..N]`
  - All elements are distinct
- Analyze the **time complexity** of the verification function.

---

### Exercice 2 – Arithmetic Expressions (Stacks)
Operations related to **infix and postfix expressions**.

Implemented tasks:
- `tokenize(expression)`  
  Converts an infix arithmetic expression into a list of tokens  
  *(without using regular expressions)*.
- Stack (`Pile`) implementation with:
  - `empiler`
  - `depiler`
  - `estVide`
- `infixeToPostfixe(expression)`  
  Converts an infix expression to postfix notation using a stack.
- `evaluerPostfixe(liste_postfixe)`  
  Evaluates a postfix expression.
- Test cases using **real numbers**.

---

### Exercice 3 – Stack Using Queue
- Implement the **Stack ADT** using only the **Queue ADT**:
  - `push(element)`
  - `pop()`
  - `size()`
- Derive the **time complexity** of each operation.

---

### Exercice 4 – Selection Sort Complexity
- Analyze the time complexity (Big-O) of a selection-sort variant.
- The algorithm repeatedly selects the **maximum element** and places it at the end.

---

### Exercice 5 – Power Computation
1. Provide a **Θ(n)** algorithm to compute `aⁿ`.
2. Provide a **Θ(log n)** algorithm to compute `aⁿ` when `n` is a power of 2.

---

### Exercice 6 – Queue Using Stack
- Given a **Stack ADT** with:
  - `push(element)`
  - `pop()`
  - `size()`
- Implement the **Queue ADT** using only stack operations:
  - `enqueue(element)`
  - `dequeue()`
  - `size()`
- Analyze the **time complexity** of each method.

---

## 🛠 Technologies
- Java / Pseudocode
- Core Data Structures (Stack, Queue, Lists)

---

## 🎯 Learning Outcomes
- Understand stack and queue implementations
- Practice expression parsing and evaluation
- Analyze algorithmic complexity
- Strengthen problem-solving skills in data structures

---

## 📂 Usage
Clone the repository and run the examples or tests provided in each exercise folder.

```bash
git clone https://github.com/your-username/data-structures-td.git
