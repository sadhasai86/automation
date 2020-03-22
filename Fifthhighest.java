package testproject;

public class Fifthhighest{  
public static int getFifthLargest(int[] a, int total){  
int temp;  
for (int i = 0; i < total; i++)   
        {  
            for (int j = i + 1; j < total; j++)   
            {  
                if (a[i] > a[j])   
                {  
                    temp = a[i];  
                    a[i] = a[j];  
                    a[j] = temp;  
                }  
            }  
        }  
       return a[total-6];  
}  
public static void main(String args[]){  
int a[]={564,120,478,1235,41,2,568,102,365,185,210};  

System.out.println("Third Largest: "+getFifthLargest(a,10));  

}}  