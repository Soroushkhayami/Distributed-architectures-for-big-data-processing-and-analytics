Welcome to the official repository for my **Distributed Architectures for Big Data Processing and Analytics** laboratory sessions at **Politecnico di Torino** (A.A. 2025/26).

This repository contains all the Java code, Maven configurations, and notes developed during the practical sessions. The coursework focuses on Hadoop MapReduce and Apache Spark to explore the fundamentals of distributed computing and large-scale data analysis.

---

## 📂 Repository Structure & Navigation

Click on the links below to dive into the specific materials, datasets, and code for each lab session.

| Session | Topic | Status | Link |
| :--- | :--- | :--- | :--- |
| **Lab 01** | Hadoop Basics, WordCount, and Environment Setup | 🟢 Available | [👉 Go to Lab 01](./Lab_01) |
| **Lab 02** | Map-only Jobs, Custom Counters, and Prefix Filtering | 🟢 Available | [👉 Go to Lab 02](./Lab_02) |
| **Lab 03** | Advanced Join Patterns & MapReduce Optimizations | 🟢 Available | [👉 Go to Lab 03](./Lab_03) |
| **Lab 04** | Introduction to Apache Spark & RDD Programming | ⏳ Coming Soon | *Link coming soon* |

---

## 🛠 Prerequisites & Setup

To run the Hadoop jobs in this repository locally or on a cluster, you will need:
* **Java SDK**: Version 17 or higher.
* **Apache Maven**: For dependency management and building JAR files.
* **Hadoop Environment**: A local Hadoop installation or access to the PoliTo JupyterHub cluster.

### Quick Build Instructions
1. Navigate to the lab folder: `cd Lab_02`
2. Build the JAR: `mvn clean package`
3. Run on Hadoop: `hadoop jar target/Lab2-1.0.0.jar <arguments...>`

