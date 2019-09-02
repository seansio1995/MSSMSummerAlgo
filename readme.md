# Mysterious Safeguards
> MSSM Summer Project For Course 49786

[![NPM Version][npm-image]][npm-url]
[![Build Status][travis-image]][travis-url]
[![Downloads Stats][npm-downloads]][npm-url]

This is an algorithm assignment to test our understanding and knowledge of data structure and algorithm.

## Question Statement
It is summer time! We hope you enjoy some COOL moment in swimming pool! 
To ensure safety, the pool owner hires N lifeguards, each of which has a shift that covers some contiguous interval of time during the day. The pool is open from time t=0 until time t=1,000,000,000 on a daily basis, so each shift can be described by two integers, giving the time at which a lifeguard starts and ends his/her shift. For example, a lifeguard starting at time t=5 and ending at time t=9 covers four units of time (note that the endpoints are "points" in time).
Unfortunately, the swimming pool owner hired 1 more lifeguard than he has the funds to support. Given that he must fire exactly one lifeguard, what is the maximum amount of time that can still be covered by the shifts of the remaining lifeguards? An interval of time is covered if at least one lifeguard is present. Please write program to find that mysterious lifeguard that has minimum impact on pool coverage. Please write the maximum coverage time to the output file.
Input File
The first line of input contains N (1≤N≤100,000). Each of the next N lines describes a lifeguard in terms of two integers in the range 0…1,000,000,000, giving the starting and ending point of a lifeguard's shift. All such endpoints are distinct. Shifts of different lifeguards might overlap.

Sample Input (1.in):
```
3
5 9
1 4
3 7
```
Please make sure that your program works for all of the 10 scenarios. Please find the 10 input files here.

Output File
Please write a single number, giving the maximum amount of time that can still be covered if the pool owner fires 1 lifeguard.
Sample Output (1.out):
```
7
```
## Solution
I borrow the idea of merge interval algorithm to solve this problem.
For each scenario, I take out one lifeguard each time and make the rest a intervals group which would be merged later. 
Suppose there are N lifeguards, we are going to have N - 1 lifeguard intervals to merge each time and repeat this N times.
Since there might be some overlaps between the N - 1 lifeguards, we need to use merge intervals algorithm to merge all the intervals.
After merging all of them, the total sum of time elapse between each interval is the total coverage time. After N times, we would have N
total coverage time and we can therefore get the maximum total coverage time of these N scenarios which is our final answer.

## Installation

OS X & Linux:

```sh
git clone project_url
```


## Usage example

Simply run the clone project in intellij to generate the output files



## Release History

*(Thanks @GenerousContributorName!)
* 0.1.0
    * The first proper release
    * Implement the merge interval algorithm
    * Calculate the coverage time for each lifeguard absence scenario and get the maximum one
* 0.0.1
    * Initialize the skeleton project to read in the input files

## Meta

About Author – [@ChufanXiao](https://github.com/seansio1995) 

Distributed under the MIT license. See ``LICENSE`` for more information.

[https://github.com/seansio1995](https://github.com/seansio1995)

## Contributing

1. Fork it (<https://github.com/yourname/yourproject/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

<!-- Markdown link & img dfn's -->
[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki
