# BrainRidge Assessment

## Prerequisites
Before running the project, make sure you have the following installed:

- Java JDK 22.0.2
- Maven

## How to build and run the project

1. Clone the repository to your local machine:

```bash
git clone https://github.com/liamhuang3/brainridge-assessment.git
```

2. Navigate to the project directory:

```bash
cd brainridge-assessment
```

3. Build the project using Maven:

```bash
mvn clean install
```

4. Run the project:

```bash
mvn spring-boot:run
```

## Assumptions
- The user balances cannot be negative
- Creating a user with no specified balance will create user with 0 balance

## API Reference

| URL               | Method | Description|
|-------------------|-------------|-------------------------------------|
| /create           | POST | Create a new user account with a specified balance |
| /transaction      | POST | Transfer funds from one user account to another |
| /transaction/{id} | GET | Get the transaction history for an account |
