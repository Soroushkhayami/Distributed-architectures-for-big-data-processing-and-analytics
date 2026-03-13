# Lab 02: Distributed Prefix Filtering & Custom Counters

## 🎯 Project Overview
This lab focuses on optimizing data processing using the **Map-only job** pattern. The goal is to filter a large dataset of words (generated in Lab 01) based on a specific prefix provided as a command-line argument.

The key challenge was to perform this filtering efficiently across a distributed cluster without the overhead of a Reducer, while simultaneously tracking statistics about the processing.

## 🛠 Key Features & Concepts
- **Map-only Optimization**: By setting `job.setNumReduceTasks(0)`, the Shuffle and Sort phases are skipped, drastically improving performance for filtering tasks.
- **Dynamic Configuration**: Using `Configuration.set()` to pass user-defined parameters (the prefix) from the Driver to all Mappers.
- **Hadoop Counters**: Implementation of custom `Enum` counters to monitor and report the number of `SELECTED` vs `DISCARDED` words in real-time across all nodes.
- **Setup Method**: Efficiently retrieving the filter prefix once per Mapper using the `setup()` method.

## 📊 Statistics from Cluster Execution
When running the job on the PoliTo Big Data Cluster with a sample prefix (e.g., "ho"), the following results were captured:

| Metric | Count |
| :--- | :--- |
| **Total Input Records** | 286,173 |
| **Words Selected (Prefix Match)** | 1,913 |
| **Words Discarded** | 284,260 |

## 🚀 Execution Guide
To build and run this job on a Hadoop cluster:

1. **Package the project**:
   ```bash
   mvn clean package
