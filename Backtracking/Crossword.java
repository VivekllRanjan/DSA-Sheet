package Backtracking;

public class Crossword {
    public static void main(String[] args) {
        char[][] arr =
                {{'+','+','+','+','+','+','+','+','+','+'},
                {'+','-','-','-','-','-','-','+','+','+'},
                {'+','+','+','-','+','+','+','+','+','+'},
                {'+','+','+','-','+','+','+','+','+','+'},
                {'+','+','+','-','-','-','-','-','+','+'},
                {'+','+','+','-','+','+','-','+','+','+'},
                {'+','+','+','+','+','+','-','+','+','+'},
                {'+','+','+','+','+','+','-','+','+','+'},
                {'+','+','+','+','+','+','-','+','+','+'},
                {'+','+','+','+','+','+','+','+','+','+'}};
        String[] Words = {"POLAND","LHASA","SPAIN","INDIA"};
        Solution(arr,Words,0);
    }

    public static void Solution(char[][] arr, String[] Words, int vidx) {

        if(vidx == Words.length){
            printArray(arr);
            return;
        }
        String word = Words[vidx];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == '-' || arr[i][j]== word.charAt(0)){
                    if(canPlaceHorizontally(i,j,arr,word)){
                        boolean[] placed = placeHorizontal(i,j,arr,word);
                        Solution(arr,Words,vidx+1);
                        unplaceHorizontal(i,j,arr,placed);
                    }

                    if(canPlaceVertically(i,j,arr,word)){
                        boolean[] placed = placeVertical(i,j,arr,word);
                        Solution(arr,Words,vidx+1);
                        unplaceVertical(i,j,arr,placed);
                    }

                }
            }
        }

    }

    private static void printArray(char[][] arr) {
        for(int i =0; i<arr.length; i++){
            for(int j=0; j<arr[0].length;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static boolean canPlaceHorizontally(int i, int j, char[][] arr, String word) {
        if(j-1 >=0 && arr[i][j-1] !='+'){
            return false;
        }
        else if(j+word.length() < arr[0].length && arr[i][j+word.length()] != '+'){
            return false;
        }

        for(int jj=0; jj<word.length(); jj++){
            if(j+jj >= arr[0].length){ ///here >=
                return false;
            }
            if(arr[i][j+jj] == word.charAt(jj) || arr[i][j+jj] == '-'){
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean canPlaceVertically(int i, int j, char[][] arr, String word) {
        if(i-1 >=0 && arr[i-1][j] !='+'){
            return false;
        }
        else if(i+word.length() < arr.length && arr[i+word.length()][j] != '+'){
            return false;
        }

        for(int ii=0; ii<word.length(); ii++){
            if(i+ii >= arr.length){
                return false;
            }
            if(arr[i+ii][j] == word.charAt(ii) || arr[i+ii][j] == '-'){
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean[] placeHorizontal(int i, int j, char[][] arr, String word){
        boolean[] placed = new boolean[word.length()];
        for(int jj=0; jj<word.length(); jj++){
            if(arr[i][j+jj]=='-'){
                arr[i][j+jj] = word.charAt(jj);
                placed[jj] = true;
            }
        }
        return placed;
    }

    public static boolean[] placeVertical(int i, int j, char[][] arr, String word){
        boolean[] placed = new boolean[word.length()];
        for(int ii=0; ii<word.length(); ii++){
            if(arr[i+ii][j]=='-'){
                arr[i+ii][j] = word.charAt(ii);
                placed[ii] = true;
            }
        }
        return placed;
    }

    public static void unplaceHorizontal(int i, int j, char[][] arr, boolean[] placed){
        for(int jj=0; jj<placed.length; jj++){
            if(placed[jj]){
                arr[i][jj] = '-';
            }
        }
    }

    public static void unplaceVertical(int i, int j, char[][] arr, boolean[] placed){
        for(int ii=0; ii<placed.length; ii++){
            if(placed[ii]){
                arr[ii][j] = '-';
            }
        }
    }

}
