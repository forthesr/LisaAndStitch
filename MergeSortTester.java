/*
Team LisaAndStitch - Yikai Wang, Kate Johnston, and Lisa Shi
APCS2 pd5
HW11 -- Wrapping It Up
2016-03-09
*/

/*======================================
  class MergeSortTester

  ALGORITHM:
  There are 5 variables in our method:
    -int n for array size.
    -int batch for number of test cases.
    -an array for populate and sort.
    -a long to store time.
    -another array to record data.

  In our main method, there are 3 for-loops:
    -one for loop for the array size.
    -another one for the number of test cases.
    -the last one to populate the array.

  The variable, l, was used to record the time before the array was sorted.
  System.nanoTime - l is then used to record the runtime per test case.
  Runtime is calculated using System.nanoTime(), since milliseconds are not acurrate enough.
  After all the cases were run, the data is printed out, along with the average runtime.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(n*log n)

  Mean execution times for dataset of size n:
  Batch size: 40
  n=1       time: ~180 nanoseconds
  n=10      time: ~9050 nanoseconds
  n=100     time: ~20800 nanoseconds
  n=1000    time: ~220000 nanoseconds
  ...
  n=<huge>  time: ~n*log base 2 (n) nanoseconds
  ANALYSIS:
  The runtime does not seem to run in n^2 time because the times are less than that of quadratic time,
  but greater than that of linear runtime.
  For instance, when n = 10, it rarely ran around 10000 nanoseconds. Instead it usually ran in ~9050 seconds or less.
  The same goes for n = 100 and n = 1000, where the runtime is about a 10 times (~log base 2 (1000^1000)/log base 2 (100^100))
  increase rather than a 100 times increase.
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * The main method's execution time is about O( log(biggest goal array size) * batch size * array size )
        It might be O( log(n) * n^2 ).

      There are 3 for loops. one within the other, for generating array size, going through test cases, and populating the array.
      Runtime is calculated using System.nanoTime() and recorded in an array after each test case. After all the cases
      were run, the data is printed out, along with the average runtime.
     ******************************/
    public static void main( String[] args ) 
    {
      int n = 1; int batch = 40; //n is the number of elements in an array
                                //batch is the number of test cases
      int[] array = new int[n];
      long l = 0; //for time
      long[] times = new long[batch]; //array to collect times (data)

      /* this code below was implemented to "warm up" the main method because the first
      test case when n = 1 ALWAYS took relatively long to run. ex: before this was implemented,
      the first runtime for n = 1 was over 500000 nanoseconds to run. That is waay too long when n = 1. */
      MergeSort.sort( array );

      for(; n < 10000; n*=10 ) { //array size gets larger ten times each iteration

        System.out.println( "Beginning testing with array size of " + n + "." );
        array = new int[n];

        for( int i = 0; i < batch; i++ ) {

          for( int x = 0; x < array.length; x++ ) { //populates array with random numbers
              array[x] = (int) (Math.random() * 20) + x;
          }
        
          l = System.nanoTime();

          MergeSort.sort( array ); //sorts

          times[i] = System.nanoTime() - l; //gets time in nanoseconds

        }

        int sum = 0; //for getting average runtime
        System.out.println( "The times (in nanoseconds) are: " );

        System.out.print( "[ " ); //prints out the data
        for( long y : times ) {
            sum += y;
            System.out.print( y + ", " );
        }
        System.out.println( "]" );

        System.out.println( "The average time is " + sum/batch + " nanoseconds.\n" );
    }

    }//end main

}//end class
