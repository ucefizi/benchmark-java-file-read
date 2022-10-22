# Benchmark Java File reading

Multithreaded file read benchmark.

Improvements coming, like: 
* more ways to read files,
* using factories to get readers
* configurable file names,
* option to read more than one file, and read whole directories

## How to use

* Run main with fail name as first argument to get numbers, like so:
  ```bash
  Using file at path '/path/to/file' with size 2147106 kb
  Starting BufferedReaderStream thread
  Starting BufferedReaderLineByLine thread
  Starting Scanner thread
  BufferedReaderStream thread took 3027999 µs to read 29998 lines
  BufferedReaderLineByLine thread took 3027999 µs to read 29998 lines
  Scanner thread took 25471500 µs to read 29998 lines
  ```
## Releases

Check [releases](https://github.com/ucefizi/benchmark-java-file-read/releases) to download a built version
