# Programming Challenge

## Purpose 

- Gauge skills and provide a medium for discussion during interview
- Your response will be reviewed before the interview and will be used as a basis for the technical questions and discussion. Please note, your final solution will be reviewed for how it solves the given problem but also how the tools provided have been utilised, i.e Git etc.

## Expectations

- Should not take much more than an hour, we do not mind if you spend longer we just realise that people have lives. 
- Complete the problems to the best of your ability. There is no hard requirement to complete every part of the challenge, just try to ensure what you do complete works. 
- Complete the challenge in any way you wish, the only provision is that it meets the **requirements**.
- You are welcome to make improvements outside of the set of the requirements however it is not expected.
- An application has been provided to assist you.


## Data 

Sourced from [QLD Gov OpenData Portal](https://data.qld.gov.au/dataset/ambient-estuarine-water-quality-monitoring-data-near-real-time-sites-2012-to-present-day/resource/0ca6f77c-4088-4d77-8c88-beae2b57ce14).



## The Application

The application reads in a csv file containing data about Baffle Creek (Current  velocity & direction), it then processes this data and outputs some summary information in a HTML for consumption via a browser. 


## Technology 

You will need, 

- JDK 11 which is available [here](https://jdk.java.net/11/), and 

- Maven 3 which can be found [here](https://maven.apache.org/download.cgi).

- [Git](https://git-scm.com/downloads)

To run the given application, 

1. ``mvn clean install``
2. ``mvn exec:java`` // NOTE: This currently does not work, feel free to fix it or use an IDE like Intellij. 

To run tests, 

``mvn test``

It is recommended to make use of an IDE such as Eclipse or Intellij. 

__NOTE:__ This activity makes use of a library called Lombok to reduce boiler plate code (ide, constructors, getters, setters, hashcode etc), if you make use of an IDE  you may need to enable support. Details of the lombok project can be found [here](https://projectlombok.org/).

## Task 

1. Clone the repository

2. Fix the tests for the existing application to ensure that it is working correctly, we do not expect this to take more than a couple of minutes.

3. Update the Summary produced by the application to include the following details, 

   - Average the totals  for each of the columns (excluding timestamp), - Please note, while the values in each cell represent averages, the task is to find the average of all values for each column.  It is worth noting that there are many ways to achieve this with no _correct_ way. 

   These will be presented in the `index.html` file that is produced through a browser. No special styling is required. 

4. Update the tests to provide coverage for these changes. 

   1. Create test/s to cover any new methods you create so that it provides what you believe is adequate enough coverage for you to be confident that it is working as expected.

5. Alter the application to read the latest data set from the QLD Govevernment Open data portal. HINT: Open data is hosted via an application called CKAN. There are multiple ways of achieving this. The data is accessible [here](https://data.qld.gov.au/dataset/ambient-estuarine-water-quality-monitoring-data-near-real-time-sites-2012-to-present-day).

6. Submit as per [Submission](#submission)


## Help

The files and methods that you will need to edit include but may not be limited to (depending on your solution), 

- ``VelocityAndDirectionService::summerise``



## Requirements

1. Read in the file found in `/src/main/resources/` called `buoy-2-current.csv` and calculate averages for all columns excluding timestamp.
2. The results must be output to a html file that is submitted upon completion (i.e stored on git.)
3. Read in the most up to date data from OpenData for the same data set as sourced from [QLD Gov OpenData Portal](https://data.qld.gov.au/dataset/ambient-estuarine-water-quality-monitoring-data-near-real-time-sites-2012-to-present-day/resource/0ca6f77c-4088-4d77-8c88-beae2b57ce14)  and complete steps one and two again but with the lastest data 
4. Write tests to provide validation of your work, they must provide adequate coverage. Be prepared to explain why your solution provides adequate coverage.
5. Submit your solution

## Submission 

__YOU WILL NOT BE ABLE TO PUSH DIRECTLY TO THIS REPOSITORY!!__

1. Clone this repository i.e ``git clone https://github.com/WorkingMouse/programming-challenge.git``
2. Create a branch, call it _firstname_lastname_. i.e ``git checkout -b  firstname_lastname``
3. Complete your solution, feel free to add and commit to your local repository. Feel free to google this or have a look at one of the many guides available like http://git.huit.harvard.edu/guide/
4 Make sure both your solution and the output index.html file are included. 
5. Create a patch of your work by running ``git diff master..firstname_lastname > firstname_lastname.patch``
6. Email your new patch file (``firstname_lastname.patch``) to serena@codebots.com
