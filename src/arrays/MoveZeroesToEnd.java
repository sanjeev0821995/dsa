package arrays;

public class MoveZeroesToEnd {
    static int[] moveZeroesToEnd(int a[]){
        int count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                swap(a,i,count);
                count++;
            }
        }
        return a;
    }
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
       int a[]=moveZeroesToEnd(new int[]{4,0,1,0,0,2,0,5,0});
       for(int i=0;i<a.length;i++){
           System.out.print(a[i]+" ");
       }
    }
}
