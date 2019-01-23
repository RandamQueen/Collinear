// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  Hannah Keating 
 *  @version 18/09/18 12:21:09
 */
class Collinear
{

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2âˆ’y3)+x2(y3âˆ’y1)+x3(y1âˆ’y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *
     * ----------------------------------------------------------
     *
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of growth: O(N^3) 
     *
     *  Explanation: There is 3 linear for loops. This usually represents a cubic algorithms,
     *  that have an order of growth of N^3. 
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3)
    {
    	 int nonHozLineAmount = 0; 
    	 int y1 =1; 
    	 int y2 = 2; 
    	 int y3 = 3; 
    	 for ( int i = 0; i < a1.length; i++) 
    	 { 
    		int x1 = a1[i]; 
    		System.out.println("Array 1");
    		for ( int j = 0; j < a2.length; j++) 
    	 	{ 
    			int x2 = a2[j];
    			System.out.println("Array 2");
    			for( int k =0; k < a3.length; k++)
    			{ 
    				int x3 = a3[k];
    				System.out.println("Array 2");
    				if(( x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2) )==0 ) 
    				{
    					nonHozLineAmount++;
    				}
    			}
    	 	}
    	 }
    		System.out.println(nonHozLineAmount);
    	return nonHozLineAmount;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: O( N^2 * log N) 
     *
     *  Explanation: The Growth convention for the insertion sort function is N^2. We have have two 
     *  linear for loops with a binary search term in them, which would use a growth convention of N^2 * logN. 
     *  Our growth convention would be N^2 + N^2 * log N. The simplified version of this would be N^2 * log N.   
     *
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
     int nonHozLineAmount = 0; 
	 int y1 =1; 
	 int y2 = 2; 
	 int y3 = 3; 
	 sort( a3); 

	 for ( int i = 0; i < a1.length; i++) 
	 { 
		int x1 = a1[i]; 
		for ( int j = 0; j < a2.length; j++) 
	 	{ 
			int x2 = a2[j];
			int neededValue = (-x1*( y2 - y3) +  -x2*( y3-y1)) / ( y1 - y2) ; 
			if( binarySearch( a3, neededValue) )
			{ 
				nonHozLineAmount++; 
			} 
		}
	 } 	
      return nonHozLineAmount;
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: O(N^2) 
     *
     *  Explanation: Two linear for-loops.
     *
     */
    static void sort(int[] a)
    {
      for ( int j = 1; j<a.length; j++)
      {
        int i = j - 1;
        while(i>=0 && a[i]>a[i+1])
        {
          int temp = a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          i--;
        }
      }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: O(logN)
     *
     *  Explanation: Binary search tend to be logarithmic algorithm. 
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
	 boolean isNumFound = false; 
	 int lowBounds =0; 
	 int highBounds = a.length -1; 

	 while( lowBounds <= highBounds &&! isNumFound) 
	 {
		int midBound = lowBounds + (highBounds - lowBounds) /2;
		int searchNum = a[midBound]; 
		if( x < searchNum) 
		{ 
		   highBounds = midBound -1; 
		} 
		else if( x > searchNum) 
		{ 
		   lowBounds = midBound +1; 
		} 
		else 
		{ 
		   isNumFound = true; 
		}
	 }
      return isNumFound;
    }
}
