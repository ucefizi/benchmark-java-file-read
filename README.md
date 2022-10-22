# Benchmark Java File reading

Multithreaded file read benchmark.

Improvements coming, like: 
* more ways to read files,
* using factories to get readers
* configurable file names,
* option to read more than one file, and read whole directories

## how to use

* Create a file in the project root named `random-junk.in` with random data and desired size for the test
* Run main to get numbers, like so:
  ```log
  running scanner with line by line
  running Buffered Reader with stream
  running Buffered Reader with line by line
  Scanner with line by line took 10778 ms
  Buffered Reader with stream took 1227 ms
  Buffered Reader with line by line took 1226 ms
  ```
