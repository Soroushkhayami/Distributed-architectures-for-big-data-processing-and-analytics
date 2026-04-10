# Lab 05: Introduction to Apache Spark & RDD Filtering

## 🎯 Project Overview
[cite_start]The objective of this laboratory is to transition from Hadoop MapReduce to **Apache Spark** using the PySpark API[cite: 2]. [cite_start]The task involves analyzing word frequency data from Amazon food reviews to compute statistics and filter results based on frequency thresholds[cite: 8].

## 🛠 Logic & Transformation
The application is divided into two main tasks:

### Task 1: Prefix Filtering & Statistics
* [cite_start]**Data Loading**: Read word frequency results from the cluster shared folder[cite: 6].
* [cite_start]**Prefix Filter**: Keep only lines where the word starts with the prefix **"ho"**[cite: 11].
* **Statistics**: 
    * [cite_start]Count the total number of lines starting with "ho"[cite: 14].
    * [cite_start]Find the **maximum frequency** (`maxfreq`) among the selected words[cite: 15].

### Task 2: Threshold Filtering
* [cite_start]**Frequency Filter**: Select words with a frequency (`freq`) greater than **80%** of the `maxfreq` calculated in Task 1[cite: 18, 20].
* **Final Output**:
    * [cite_start]Count the final number of filtered lines[cite: 22].
    * [cite_start]Save the final list of words (without their frequencies) to an output folder[cite: 22].

## 📂 Folder Contents
* `Lab_05.ipynb`: The complete PySpark implementation.
* `Lab5_DBD_2025_2026.pdf`: Detailed problem specifications.
* `OutputFolderLab1/`: Sample output from Lab 1 for reference.

---
> [cite_start]**Note**: As per university requirements, the JupyterHub server must be shut down via the **Hub Control Panel** (Stop My Server) after finishing the session[cite: 39, 43].