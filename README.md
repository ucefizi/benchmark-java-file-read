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
  ```bash
  Using file at path '/path/to/random-junk.in' with size 2147106 kb
  Starting BufferedReaderStream thread
  Starting BufferedReaderLineByLine thread
  Starting Scanner thread
  BufferedReaderStream thread took 3027999 µs to read 29998 lines
  BufferedReaderLineByLine thread took 3027999 µs to read 29998 lines
  Scanner thread took 25471500 µs to read 29998 lines
  ```
