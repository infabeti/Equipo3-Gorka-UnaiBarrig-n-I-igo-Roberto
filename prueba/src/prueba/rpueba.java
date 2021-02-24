package prueba;

import java.util.Arrays;

public class rpueba {

	
		public static void main(String[] args) {
	        String[] valores = {"uno", "dos", "tres"};
	 
	        System.out.println(Arrays.toString(valores));
	 
	        removeIndex(valores, 0);
	 
	        System.out.println(Arrays.toString(valores));
	    }
	 
	    private static void removeIndex(String[] array, int index) {
	        int i = index;
	        for (; i < array.length - 1; i++) {
	            array[i] = array[i + 1];
	        }
	        array[i] = null;
	    }

	

}
