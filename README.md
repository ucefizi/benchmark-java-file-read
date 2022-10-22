# Benchmark Java File reading

* Create a file in `src/com/izi` named `random-junk.in` with random data and desired size for the test
* Run main to get numbers, like so:
  ```log
  running scanner with line by line
  nbr lines 19998
  Scanner with line by line took 10677 ms
  running Buffered Reader with entire file
  Buffer size 1048576
  nbr lines 19998
  Buffered Reader with entire file took 1057 ms
  running Buffered Reader with line by line
  Buffer size 1048576
  nbr lines 19999
  Buffered Reader with line by line took 930 ms
  ```
