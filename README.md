# SOCKETS, THREADS AND REFLECTION DEMO

> Author : Brian Kitunda <briankathukya2000@gmail.com>

## Flow

### App class
- This class makes the necessary configuurations and accepts socket connections

### PreProcessor
- Accepts the request from the user and routes it.
- There are three possible requests namely : CREATE, BUY and BAL
- __CREATE__ is used to create a user account. It takes the shape : __CREATE accountNumber__
- __BUY__ is used to buy tokens. It takes the shape : __BUY accountNumber amount__
- __BAL__ is used to check the account balance. It takes the shape : __BAL accountNumber__

### CustomerProcessor
- Called to create an account

### BalanceProcessor
- Called to check balance

### RechargeProcessor
- Called to buy tokens

## Models
### Customer
- accountNumber
- tokenAmount

## Core
### Processor
- Has a method called __queue__ that passes data from one class to another
- We queue to another class and invoke the __process__ method of it.
- Some of the things that are carried through are
    * request : String -> This is the string representation of the user input.
    * customerRepository : CustomerRepository -> This is an interface to JDBC.
    * dataSource : DataSource -> Needed by customerRepository to handle db operations.
    * processorConfig : Map<String, String> -> Holds processor name and processorClass read from config.xml
    * socket : Socket : This is the current client socket -> results are written to it.