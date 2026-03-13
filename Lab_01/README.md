# Lab 01: Introduction to Hadoop & Distributed WordCount

## 🎯 Project Overview
This introductory laboratory focuses on the "Hello World" of Big Data: the **WordCount** algorithm. The goal is to process a large collection of text documents and compute the total frequency of each word using the Apache Hadoop MapReduce framework.

## ⚙️ MapReduce Logic
The implementation follows the standard two-phase distributed processing pattern:

1. **Mapper**: 
   - Receives lines of text as input.
   - Cleans the text (converts to lowercase, removes punctuation).
   - Emits a key-value pair for each word: `(word, 1)`.
2. **Reducer**:
   - Aggregates all values for a specific word.
   - Calculates the final sum: `(word, total_count)`.

## 🛠 Features
- **Data Cleaning**: Implemented basic text preprocessing to ensure words like "Data" and "data!" are counted as the same entity.
- **Scalability**: Designed to run seamlessly on a distributed HDFS cluster, processing files that are too large for a single machine's memory.
- **Maven Integration**: Organized as a standard Java project for easy dependency management and JAR packaging.

## 📊 Dataset
The job was tested on the cluster using sample text documents provided by the course, successfully generating an alphabetized list of word frequencies.

## 🏃 How to Run
1. **Build the JAR**:
   ```bash
   mvn clean package

