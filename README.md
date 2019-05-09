# TalaeeAndroid
Talaee Repository
1. Java Array:

   fixed size
   
   contains both primitive type and object type
   
   In case of primitive types: actual values are contiguous memory locations
   
   In case of object type: actual objects are not stored at contiguous memory locations
   
   array members are accessed using []
   
         int[] arr = new int[2]; 
              arr[0] = 1; 
              arr[1] = 2; 
        
         int[] arr = new int[2]{2,3}; 
   
   
2. Java ArrayList:
    
    Dynamic size
    
    only supports object type
    
    the actual objects are not stored at contiguous locations. 
    
    References of the actual objects are stored at contiguous locations.

            ArrayList<Object> arrL = new ArrayList<Object>(); 
            ArrayList<Object> arrL = new ArrayList<Object>(2); //arrayList with initial capacity 2


3. Java List vs ArrayList

    List:
    
      List is an interface which extends Collection.
        
      A list object can be created as below:
        
          List a= new ArrayList();
