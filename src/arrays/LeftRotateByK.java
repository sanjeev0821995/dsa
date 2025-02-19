package arrays;

public class LeftRotateByK {
    static int[] rotateArrayByK(int a[]){
        int temp=a[0];
        for(int i=1;i<a.length;i++){
            a[i-1]=a[i];
        }
        a[a.length-1]=temp;
        return a;
    }
    static int[] optimize(int a[],int k){
        reverse(a,0,k-1);
        reverse(a,k,a.length-1);
        reverse(a,0,a.length-1);
        return a;
    }
    static void reverse(int a[],int i, int j){
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int k=2;
        int a[]={4,6,2,3,7,0};
        for(int i=0;i<k;i++){
            rotateArrayByK(a);
        }
        for(int i:a)
            System.out.print(i+" ");
        optimize(a,k);
        System.out.println();
        for(int i:a)
            System.out.print(i+" ");
    }
}
