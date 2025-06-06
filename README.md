# Multithreading
This project demonstrates the concept of **Multithreading in Java**, a fundamental feature that enables the concurrent execution of two or more threads for better resource utilization and faster program execution.

---

## What is Multithreading?

Multithreading is a programming technique where **multiple threads** (lightweight processes) run independently but share the same memory space. It is a key part of Java's concurrency model.

**Why use multithreading?**
- Perform multiple tasks simultaneously
- Improve performance on multi-core systems

---

## ⚙️ Thread vs Process

| Feature      | Thread                        | Process                      |
|--------------|-------------------------------|------------------------------|
| Memory       | Shares memory with other threads | Has its own memory           |
| Communication| Easier (shared memory)        | More complex (IPC)           |
| Overhead     | Low                           | High                         |
| Isolation    | Less (can affect each other)  | More secure (isolated)       |

---

## 🔄 Thread Lifecycle

A thread in Java goes through the following **states**:

1. **New** – Thread object created but not started
2. **Runnable** – After calling `start()`, ready to run
3. **Running** – Actually running on the CPU
4. **Blocked/Waiting** – Waiting for a resource or signal
5. **Terminated/Dead** – Execution finished or stopped



