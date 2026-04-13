/**********************************
 *  Student Name:   REDACTED
 *      Username:   REDACTED
 *    Assignment:   PS2
 *      Due Date:   March 16, 2026
 **********************************/
class PS2Arrays{
    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4};
        int[][] cartesianProduct = new int[a.length * b.length][2]; // the amount of items in a cartesian product is the amount of items in A * the amount of items in B
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++){
                cartesianProduct[count] = new int[]{a[i], b[j]}; // since the length is already declared, the array must be declared like this
                count++;
            }
        }
        
        System.out.print("A X B = {");
        for(int i = 0; i < cartesianProduct.length; i++){
            System.out.print("(");
            for(int j = 0; j < cartesianProduct[i].length; j++){
                System.out.print(cartesianProduct[i][j]); 
                if(j != cartesianProduct[i].length - 1){ // comma check
                    System.out.print(",");
                }
            }
            System.out.print(")");
            if(i != cartesianProduct.length - 1){ // comma check 2
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}
