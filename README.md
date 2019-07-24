# Java-Bank-Account
This is my code for a coding challenge that involved creating a java class for a bank account. I initially started this project after completing a coding challenge from the Java Masterclass on Udemy(taught by Tim Buchalka), but decided to expand on the concepts to test my understanding of Polymorphism and Anonymous classes. This was also a good exercise for me to write my own unique program of the Udemy course.

This program can be expanded by adding a bank class that would contain all of the users (customers of that bank) and allow users to send/receive money to and from one another. Additionally an "atAtm" parameter can be added to the withdrawal, deposit, and transfer methods so that daily limits could be added as they are in the real world. 

## How to execute in windows Terminal
Compile
-------
- javac -s src/com/williamEnnals -d bin src/com/williamEnnals/classes/classTypes/AccountTypes.java src/com/williamEnnals/classes/\*.java src/com/williamEnnals/classes/accounts/\*.java src/com/williamEnnals/application/Main.java

Execute
-------
- java -cp bin com.williamEnnals.application.Main

## How to push code to the github
- git add .
- git commit -m "A message goes here"
- git push origin <branch name>

## Commands to remember
- git status (This command allows you to check with files are staged for or un-tracked)
- git checkout -b <new branch name>
- git pull origin <branch name> (This will pull down the code currently in github for the branch you're working on, it will override any unsaved changes)
- git stash (removed unsaved changes and stores them in cache, these changes can be retrieved if desired)
