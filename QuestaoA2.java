import java.util.Scanner;

public class QuestaoA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casosTeste = Integer.valueOf(sc.nextLine());
        int sorte = 0;
        for (int i = 0; i < casosTeste; i++) {
            String[] valores = sc.nextLine().split(" ");
            Integer n = Integer.valueOf(valores[0]);
            Integer k = Integer.valueOf(valores[1]);
            int[] array = geraArray(n);
            sorte += conta(array,1, n, k);
            System.out.println(sorte);
            sorte = 0;
        }
    }

    public static int meio(int left, int right, int k) {
        int m = (right+left)/2;
        if((right-left+1)%2 ==0){
            if(right-left+1<=k) {return 0;}
            return meio(left, m-1, k) + meio(m, right, k);
        }
        else{
            if(right-left+1<=k) {return m;}
            return m + meio(left, m-1, k) + meio(m+1, right, k);
        }

}
    public static int[] geraArray(int n){
        int[] novoArray = new int[n];
        for(int i = 0;i<n;i++){
            novoArray[i] = i+1;
        }

        return novoArray;
    }


    static int conta(int[] array, int left, int right, int k){
        int meio = (array[left]+array[right])/2;
        if(array.length %2 == 0){
            if(array[right]<k){
                return 0;
            }
            return conta(array, left, meio-1, k) + conta(array, meio+1, right, k);
        }
        if(array[right]<k){
            return array[meio];
        }
        return meio + conta(array, left,meio-1,k) + conta(array,meio+1,right,k);
    }
}
