# Lab 04: Rating Normalization on Amazon Food Dataset

## 🎯 Project Overview
[cite_start]This project focuses on removing **user bias** from ratings in a large-scale Amazon food dataset[cite: 2, 7]. [cite_start]Since some users are naturally critical and others are overly generous, we normalize each rating by subtracting the user's personal average score[cite: 31].

## 🧮 Logic & Transformation
The application performs a two-step normalization process:

1. [cite_start]**User Average Calculation**: For each user, we compute the mean of all their provided ratings ($1$ to $5$ stars)[cite: 3, 31].
2. **Rating Normalization**: We subtract the user's mean from each of their individual ratings.
   - [cite_start]*Example*: If User A4's average is $4.0$ and they gave Product B3 a $5$, the normalized rating is $+1.0$ (they liked it)[cite: 51].
3. [cite_start]**Global Product Average**: Finally, we compute the average of these normalized scores for each product to find its true ranking[cite: 53].

## 🛠 Technical Implementation
- [cite_start]**Framework**: Apache Hadoop MapReduce (Transitioning to Spark concepts).
- [cite_start]**Data Sparsity**: Optimized to handle sparse matrices where most users have only rated a few products[cite: 72, 73].
- [cite_start]**Efficiency**: Implemented local Java variables to store user ratings to minimize network overhead[cite: 73, 75].

## 🏃 Execution
1. [cite_start]**Input**: `Reviews_cleaned.csv` containing `ProductId`, `UserId`, and `Score`[cite: 57, 61, 64].
2. **Build**: `mvn clean package`
3. **Run**:
   ```bash
   hadoop jar target/Lab4-1.0.0.jar it.polito.bigdata.hadoop.DriverBigData <input_path> <output_path>