package as_cellular_automaton;

/* scanner utility created by NetBeans*/

import java.util.Scanner;

/**
*
* @author iCloud
*/
public class AS_Cellular_Automaton {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {

    /*Prompt the user to enter the number of cells c*/
    
    Scanner input = new Scanner(System.in);
    int c,i,n;
    System.out.println("Welcome to the cellular automaton simulation!");
    System.out.print("Enter number of cells (<= 80): ");
    c=input.nextInt();
    
    while(c<1||c>80){
        System.out.println("invalid length");
        System.out.print("Enter number of cells (<= 80): ");
        c=input.nextInt();
        }
    
    /*Declare an integer array cell[] with C elements*/ 
    
    int []cells=new int[c];
    
    /*Prompt the user to enter the number of time steps*/ 
    
    for(i=0;i<c;i++)
        cells[i]=0;
    System.out.print("Enter number of time steps: ");
        n=input.nextInt();
        
        /*Prompt the user to enter the index of cells that contain 1
		(enter negative index to finish)*/

        System.out.print("Enter the index of occupied cells (negative index to end): ");
        i=input.nextInt();
        
        /*test cells, loops to check and run, and call methods for each steps*/ 
        
    while(i>=0){
        if(i<c)
        cells[i]=1;
    i=input.nextInt();
        }
    System.out.println();
    for(i=0;i<c;i++)
        System.out.print(i%10);
    System.out.println();   
    System.out.println();
        displayCells(cells);
        for(i=0;i<n;i++){
            updateCells(cells);
            displayCells(cells);
        }
    }

/*Run the cellular automaton for N time steps, using the rules defined above
On each time step, display the cells, printing a ‘#’ if the cell contains a 1, 
a space if the cell contains a 0*/ 

/*method #1 - to display related #'s shapes to determined results above*/ 

/*displayCells() prints each cell of the data[] array on the same line, displaying 
a ‘#’ if the cell contains a 1, a space if the cell contains a 0.*/ 

public static void displayCells(int data[]){
int i;
for(i=0;i<data.length;i++)
if(data[i]==0)
    System.out.print(" ");
else
    System.out.print("#");
    System.out.println();
}

/*method #2 - to update cells in each following cell based on giving conditions schedule*/

/*updateCells() updates each cell in the data[] array, according to the rules defined 
earlier in this handout, for one step.*/ 

public static void updateCells(int a[])
{int n,i;
n=a.length;
int []t=new int[n];
t[0]=a[0];
t[n-1]=a[n-1];
for(i=1;i<n-1;i++)
    t[i]=1;
for(i=1;i<n-1;i++)
    if((a[i-1]==1&&a[i]==1&&a[i+1]==1)||
        (a[i-1]==1&&a[i]==0&&a[i+1]==0)||
        (a[i-1]+a[i]+a[i+1]==0))
             t[i]=0;
for(i=0;i<n;i++)
   a[i]=t[i];
}
}
