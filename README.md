# README

## Overview

This application is a console-based messaging system developed in Java. It allows users to register an account, log in, create messages, send messages, store messages in a JSON file, and generate reports on stored and sent messages.

The system consists of three main components:

* **Main Class** – Controls the program flow and user interaction.
* **Login Class** – Handles registration and login validation rules.
* **Message Class** – Handles message creation, validation, storage, retrieval, reporting, and message statistics.

---

# Features

## 1. User Registration

The user is required to enter:

* First Name
* Last Name
* Username
* Password
* Cell Phone Number

The system validates the information according to predefined rules before registration is completed.

### Username Rules

The username must:

* Contain an underscore (_)
* Be no longer than 5 characters

### Password Rules

The password must:

* Be at least 8 characters long
* Contain a capital letter
* Contain a number
* Contain a special character

### Cell Phone Number Rules

The cell phone number must:

* Include an international country code
* Follow the required format

---

## 2. User Login

After successful registration:

* The user's details are stored.
* The user enters their username and password.
* The system verifies the credentials.
* A login status message is displayed.

### Login Validation

The program confirms:

* Username matches the registered username.
* Password matches the registered password.
* Login attempt is successful.

---

## 3. Message Handling

After a successful login, the messaging system becomes available.

The user can:

* Create messages
* Send messages
* Store messages
* Disregard messages
* View reports and message statistics

---

# Message Validation

## Message Length

Messages may not exceed **250 characters**.

If the limit is exceeded:

* The message is rejected.
* The user is informed how many characters exceed the limit.

---

## Recipient Validation

The recipient number must:

* Include a valid international country code.
* Follow the required phone number format.

---

# Message Identification

## Message ID

Every message receives a unique:

* 10-digit Message ID

The Message ID is automatically generated.

---

## Message Hash

The system automatically creates a message hash.

The hash is generated using:

* The first two digits of the Message ID
* The message number
* The first word of the message
* The last word of the message

Example:

08:1:HELLO:WORLD

The hash is converted to uppercase.

---

# Message Actions

After entering a valid message, the user may choose one of three options:

## Send Message

When a message is sent:

* Message ID is displayed
* Message Hash is displayed
* Recipient Number is displayed
* Message Content is displayed

The message is added to the sent message collection.

---

## Store Message

When a message is stored:

* The message is saved to a JSON file using Gson.
* Message details are preserved between program executions.
* Stored messages can later be viewed, searched, or reported on.

---

## Disregard Message

When a message is disregarded:

* The message is discarded.
* No message data is saved.
* The message is added to the disregarded message counter.

---

# JSON Storage

The application uses the Gson library to store message data in JSON format.

Stored information includes:

* Message ID
* Message Hash
* Recipient Number
* Message Content
* Sender Information

The JSON file acts as permanent storage for saved messages.

---

# Message Reports and Queries

The system includes several reporting functions.

## Display Sent Messages

Displays:

* Message ID
* Recipient
* Message Content
* Message Hash

For all messages that were sent.

---

## Display Longest Message

The system can:

* Search through all sent messages
* Identify the longest message
* Display its contents

---

## Search by Message ID

The user can search for a specific message using its Message ID.

The system returns:

* Recipient
* Message Content

if the message exists.

---

## Search by Recipient

The user can search using a recipient phone number.

The system displays:

* All messages sent to that recipient

---

## Delete Message by Hash

The user can delete a message using its Message Hash.

When deleted:

* The message is removed from the collection.
* The updated message list is displayed.

---

## Full Sent Message Report

A complete report can be generated showing:

* Message ID
* Message Hash
* Recipient
* Message Content

for every sent message.

---

# Message Statistics

The system keeps track of:

## Total Messages Sent

A running count is maintained of all messages successfully sent.

---

## Stored Messages

The application tracks:

* Total stored messages

---

## Disregarded Messages

The application tracks:

* Total disregarded messages

---

# Program Flow

## Registration Phase

1. User enters registration details.
2. Main creates a Login object.
3. Main passes user information using setter methods.
4. Validation methods verify all requirements.
5. Registration results are displayed.

---

## Login Phase

1. User enters login credentials.
2. Login object verifies username and password.
3. Login status is displayed.

---

## Messaging Phase

1. Main creates a Message object.
2. User enters:

   * Recipient Number
   * Message Content
3. Validation checks are performed.
4. Message ID is generated.
5. Message Hash is generated.
6. User selects:

   * Send
   * Store
   * Disregard
7. Appropriate action is performed.
8. Message statistics are updated.

---

# Unit Testing

The project includes JUnit tests to verify application functionality.

Tests cover:

* Username validation
* Password validation
* Cell phone validation
* Login verification
* Message length validation
* Recipient validation
* Message hash generation
* Message ID generation
* Send message functionality
* Store message functionality
* Disregard message functionality
* Message searching
* Message deletion
* Message reporting functions

These tests help ensure that all program requirements function correctly and continue to work after future updates.

---

# Technologies Used

* Java
* Maven
* JUnit 5
* Gson
* JSON File Storage

---

# Author

Messaging Application Project

Built as part of a software development assignment demonstrating:

* Object-Oriented Programming
* Input Validation
* File Handling
* JSON Data Storage
* Unit Testing
* Data Searching and Reporting
