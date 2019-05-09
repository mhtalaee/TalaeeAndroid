# TalaeeAndroid
Talaee Repository
1. Java Array:

   fixed size
   
   contains both primitive type and object type
   
   In case of primitive types: actual values are contiguous memory locations
   
   In case of object type: actual objects are not stored at contiguous memory locations
   
   array members are accessed using []
   
   <pre><code>
   int[] arr = new int[2]; 
        arr[0] = 1; 
        arr[1] = 2; 
    </code></pre>
        
<pre><code>        
   int[] arr = new int[2]{2,3}; 
</code></pre>   
   
   
2. Java ArrayList:
    
    Dynamic size
    
    only supports object type
    
    the actual objects are not stored at contiguous locations. References of the actual objects are stored at contiguous locations.

<pre><code>
    ArrayList<Object> arrL = new ArrayList<Object>(); 
    ArrayList<Object> arrL = new ArrayList<Object>(2); //arrayList with initial capacity 2
</code></pre>
        
