# 📊 Lab 1: Introduction to Hadoop MapReduce

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Hadoop](https://img.shields.io/badge/Hadoop-66CC00?style=for-the-badge&logo=apachehadoop&logoColor=white)

> **Objective:** Understand the fundamentals of the Hadoop MapReduce framework by implementing a distributed Word Count application.



## 🧠 What We Did in This Lab

In this laboratory, we built a standard MapReduce application from scratch using the Java API. The goal of the application is to read a collection of text documents and calculate the total frequency of each word across the entire dataset.

The project is broken down into three main Java classes:

1. **`MapperBigData.java`**: The Map phase. It reads the input text line by line, splits the text into individual words, and outputs a key-value pair for every single word found in the format: `(word, 1)`.
2. **`ReducerBigData.java`**: The Reduce phase. Hadoop automatically groups all the identical words together. The Reducer then takes a word and its list of `1`s, sums them up, and outputs the final count: `(word, total_count)`.
3. **`DriverBigData.java`**: The main entry point. It configures the Hadoop job, specifies the input/output paths in HDFS, and defines which classes to use for the Mapper and Reducer.

---

## 🛠️ Repository Structure

* `📁 src/it/polito/bigdata/hadoop/` — The Java source code.
* `📁 example_data/` — A sample `.txt` dataset for testing.
* `📦 Lab1_BigData_with_libraries_vscode.jar` — The compiled executable JAR file.

---

## 🚀 Execution Instructions

To run this specific lab on your Hadoop cluster, follow these steps:

**1. Upload the dataset to HDFS:**
```bash
hdfs dfs -put example_data/ /user/hadoop/input_data
