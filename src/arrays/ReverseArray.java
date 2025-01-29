package arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int a[]={3,56,7,23,45,6,4};
        int left=0;
        int right=a.length-1;
        while(left<right){
            int temp=a[left];
            a[left]=a[right];
            a[right]=temp;
            left++;
            right--;
        }
        for(int i:a)
            System.out.print(i+" ");
    }
}
