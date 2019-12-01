The program starts with two arguments:
1. the file with csv data
2. the file where the incorrect data will be stored
Initially read the file line by line and check if the required number of fields are entered. 
If the number is less than 10 the data is transcribed into the file with incorrect data and the number of incorrect records is increased.
Otherwise it is entered in the database, initially it is checked if the connection was established and the table is created, otherwise it is done, then the data is inserted in the table.
  The number of registrations received, with errors and successfully entered in the log file.
