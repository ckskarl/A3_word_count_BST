Assignment 3 - Binary Search Trees and Serialization

In the program we had use the BSTreeADT to create a working version of BSTReferencedBase, and BSTNode.
The working BST structure is then used in our WordTracker application to read text files and collect and store
all the unique words it finds in those files. The BSTReferencedBase will store information from multiple text files,
and it will keep track of each occurrence of a word in a file and the line it was found in that file. The program
will output to the command line a report using the iterator built into the BST.

The program is complete in it's functionality = 100%.




How to run:
Navigate to the runnable jar file located within the folder in the project via command line. 
Enter in the name of the text file you wish to read.

The user should be able to specify 3 mutually exclusive options at command line:
a) -pf to print in alphabetic order all words along with the corresponding list of files in which the words occur
b) -pl to print in alphabetic order all words along with the corresponding list of files and numbers of the lines in which the word occur
c) -po to print in alphabetic order all words along with the corresponding list of files, numbers of the lines in which the word occur and the frequency of occurrence of the words.
(Optional)The user should be able to redirect the report in the previous step to a file with an additional option –fFilename.


Noted that the file input path and file output path CANNOT contain any white space.

following are valid input:
1) java -jar Tracker.jar C:\\CPRG311\\sample.txt -po -fC:\\CPRG311\\Report.txt
2) java -jar Tracker.jar C:\\CPRG311\\sample.txt -po 
3) java -jar Tracker.jar -pf C:\\CPRG311\\sample.txt 
4) java -jar Tracker.jar -fC:\\CPRG311\\Report.txt C:\\CPRG311\\sample.txt -pl

following are invalid input:
1) java -jar Tracker.jar C:\\CPRG311\\sample.txt -po -fC:\\CPRG311\\Report with white space.txt                 <<<<file path contains white space
2) java -jar Tracker.jar C:\\CPRG311\\sample.txt 																<<<<missing option (-pf, -pl or -po)
3) java -jar Tracker.jar C:\\CPRG311\\sample.txt -pp															<<<<incorrect option

Author: Brandon Donkersloot, Alex Fleury, Christian Lay, Kin Shing Chong