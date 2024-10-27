# Lost World - (Arbisoft) 2023 Fresh Grad Test

You have been traveling back and forth in time with a group of millionaires and scientists. A time machine accident has left your group stranded in the ancient past. Your only hope of being rescued is to screw up the timeline so much that the time police will notice. Messing with timelines is almost an impossible task. It requires executive access to the timeline data and understanding of complex operations . Your fellow fresh graduates that are now working in arbisoft have noticed that you have been missing from the office for more than 5 years now. They have decided to open up a secret api portal that will allow you to receive data that can possibly help you disrupt the timeline.

Though most of the data retrieved from the secret portal makes no sense. Your only hope is to interpret the data from the secret portal and respond back to the time police helpline with a secret key number that will disrupt the timeline.

Scientists have suggested, following random data manipulation might help us generate a final number required to disrupt the timeline. The only reasonable input from millionaires is an influencing quote “Hustle but strictly stick to guidelines and remember your aim, that is to get us back”.


Here are the list of steps your group has decided to perform:

 

Read the trip id from the time machine logs eg input file

Input File 

b/ITZH

 

Use trip id from input file to retrieve timelines, their masks labels and action plan using timelines portal api:

Api-url :

https://jsonkeeper.com/b/ITZH

 

Sample Response:

```python
{"status": "True"

    "data": {

        "timelines": [ 1, 2, 44, 555, 0, 0 ],

        "masks": ["Are", "Are", "you", "HIGH", "you", "HIGH" ],

        "action_plan": {

            "operation": "FOO",

            "sub_operations": {

                "Are": "BAR",

                "you": "FOX",

                "HIGH": "BAR"

            }

        }

    }

}
```
 

Timelines are numeric values. Each index of the timeline array has a corresponding mask value stored in the masks array. For example index 0 of timeline array has value 1 with corresponding mask value of “Are”. Index 5 of the timeline array has value 0 with corresponding mask value of “HIGH” and so on. 

 

“Action_plan” variable consists of operation and sub_operations. Sub operations are defined as key value pairs. You need to perform a “BAR” operation on the data that belongs to the “Are” mask label. 

 

Operation and sub-operations will be performed following the steps mentioned below:
Group the values from timelines array that belong to the same mask labels.
Use translation table below and information retrieved from timeline api to perform sub operations on the data grouped in step 1 for each respective mask. This shall output a single value for each mask label. 
Perform final operation using translation table below on the resulting data set from different masks sub-operations.
Feed the final result to the time police helpline eg console output in our case.
 

Translation Table

 

Operation Keyword

Actual Operation

FOO

SUM

FOX

MAX

BAR

MIN




Example Scheme Dry Run

 

Sample Data retrieved from timelines api 
 "timelines": [ 1, 2, 44, 555, 0, 0 ],

 "masks": ["Are", "Are", "you", "HIGH", "you", “HIGH"]

 

"operation": "FOO"

"sub_operations": {  "Are": "BAR",  "you": "FOX", "HIGH": "BAR"}

 

Timelines grouped by mask labels
“Are”: [1, 2]
“you”: [44, 0] 

“HIGH”: [555, 0]

 

Resultant data after performing sub-operations on masked labeled data as per translation table above
 

 “Are”:  Min ([ 1, 2])  = 1

 “you”:  Max ([44, 0] )    = 44

“HIGH”: Min ([ 555, 0 ])      = 0

 

“data” : [1, 44, 0]

 

Final Step
Operation: “FOO” translates to SUM operation

1+44+0 = 45

Output: 45 




Limitations & Assumptions

For all test case this condition will hold
Size of Timeline Array == Size of Masks Array

0 < Size of Timelines /Masks Array < 10^6
0 < Number of SubOperations < Size of Mask Array
Number of Operation = 1 
For most cases there will be sub operation for any given key that is part of the masks array. In case a sub operation is missing for any mask label, the calculated value for that mask can be assumed to be 0.
Lookout for api portal timeouts !
