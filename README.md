# Benchmark Java File reading

* Create a file in `src/com/izi/tasks` named `random-junk.in` with random data and desired size for the test
* Run main to get numbers, like so:
  ```log
  running scanner with line by line
  running Buffered Reader with stream
  running Buffered Reader with line by line
  Scanner with line by line took 10778 ms
  Buffered Reader with stream took 1227 ms
  Buffered Reader with line by line took 1226 ms
  ```
