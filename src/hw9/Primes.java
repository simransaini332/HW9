package hw9;

import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class Primes
{

    public static void main(String args[])
    {

        int max;
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        // COMPLETE THE MAIN
        ListInterface<Integer> candidates=new AList<Integer>();
        ListInterface<Integer> composites=new AList<Integer>();
        ListInterface<Integer> primes=new AList<Integer>();
        int i;
        for(i=2;i<=max;i++)
        {
        	candidates.add(i);         //add candidates to list
        }
        System.out.println("The candidates list is " + candidates);
        
        while(candidates.getLength()!=0)       //loop through till candidate list is empty
        {int prime=candidates.getEntry(1);     //get first entry
        //System.out.println(prime);
        primes.add(prime);                      //add prime to prime list
        candidates.remove(1);                     //remove it from candidate list
        getComposites(candidates,composites,prime);       //call get composition method 
        }
        System.out.println("prime numbers less than and equal to "+max+"are");
        System.out.println(primes);
        
    }
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
        // COMPLETE THIS METHOD
    	int i=1;
    	while(i<=candidates.getLength())     //loop through whole candidate list
    	{
    	 if(candidates.getEntry(i)%prime==0)    //check if number is divisible by prime
    	 {
    		 composites.add(candidates.getEntry(i));     //add composite number to composite list
    		 candidates.remove(i);                       //remove candidate
    	 }
    	 else
    		 i++;
    	}
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}

