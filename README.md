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
          
    ArrayList:
     
      ArrayList is a class which implements the List interface.
      
      Manipulation is slow in array list as shifting needs to be done if any element is removed from a list
      
4. Advantage of Java Generics
   Type-safety
   Type casting is not required
   Compile-Time Checking
   
   Non-Generic collection
   
         List list = new ArrayList();
         list.add("hello");
         list.add(1);
         String str = (String) list.get(0);
         
   Generic collection
   
         List<String> genericList = new ArrayList<String>();
         genericList.add("hello");
         genericList.add(1); //runtime error because of wrong data type
         String gStr = genericList.get(0); //no type mapping is requird
         
5. Generic class

         class Test<T>     //<T> means that youe must define type parameter when making an instance of the class
         { 
            T obj; 
            Test(T obj) {    // constructor 
            this.obj = obj;  
            }
         }  

   Make instance of this generic class
   
         Test <Integer> iObj = new Test<Integer>(15); 
         Test <String> sObj = new Test<String>("GeeksForGeeks"); 

         
         

