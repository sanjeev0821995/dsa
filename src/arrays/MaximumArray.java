package arrays;

public class MaximumArray {
    static int max(int a[]){
        int max=0;
        for(int i=1;i<a.length;i++){
            if(a[i]>a[max])
                max=i;
        }
        return max;
    }
    static int secondMax(int a[]){
        int largest=max(a);
        int secondMax=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]!=a[largest]){
                if(secondMax==-1){
                    secondMax=i;
                }
                else if(a[i]>a[secondMax]){
                    secondMax=i;
                }
            }
        }
        return secondMax;
    }
    static int optimizeSecondMax(int a[]){
        int largest=0,secondLargest=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]>a[largest]){
                secondLargest=largest;
                largest=i;
            }
            else if(a[i]!=largest){
                if(secondLargest==-1 || a[i]>a[secondLargest]){
                    secondLargest=i;
                }
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int a[]={22,33,24,54,35,33,26};
        System.out.println("Maximum Element = "+a[max(a)]);
        System.out.println("Second Maximum Element = "+a[secondMax(a)]);
        System.out.println("Second Maximum Element = "+a[optimizeSecondMax(a)]);


    }
}
