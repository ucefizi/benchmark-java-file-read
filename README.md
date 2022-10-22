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
  Using file at path: /path/to/random-junk.in
  Starting Scanner thread
  Starting BufferedReaderStream thread
  Starting BufferedReaderLineByLine thread
  Scanner thread took 11522 ms to read 19998 lines
  BufferedReaderStream thread took 1372 ms to read 19998 lines
  BufferedReaderLineByLine thread took 1372 ms to read 19998 lines
  ```
