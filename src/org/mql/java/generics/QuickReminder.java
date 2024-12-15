package org.mql.java.generics;

import java.util.Vector;

public class QuickReminder {

	
	public QuickReminder() {
		exp05();
	}
	
	
	void exp01() {
		// a partir de jdk5 on a genericite (parametrer un type) => Compile-time Feature
		Vector <String> v = new Vector<>();  //diamond operator <>
		                              // Inference de type <>(jdk7)  c est quoi inferer 
		v.add("Node.js");
		v.add("java");
	    v.add("JEE");
	    for (String element : v) {
	    	System.out.println(element);
			
		}
	}

	class Point {}
    class Pixel extends Point {}
	
    void exp02() {
    	// a Pixel is a Point // Vector<Point> is not a  Vector<Point>; // affectation fille -> mere
    	
    	Point p1 = new Pixel(); 
    	Vector<Point> v1 = new Vector<Point>(); // new Vector<Pixel>(); //faux
        v1.add(new Pixel());
         
         Vector<Pixel> v2 = new Vector<>();
         print(v1);
         
         // print<v2> // faux
         // le wildcard ? : Type inconnu
         
         Vector<?> v3 = new Vector<Pixel>();  // passer un parametre a gerer pas a modifier 
         //V3.add(new Pixel()); // car le type des elm de v3 est inconnu 
         v3.add(null);
         
         Vector<?> v4 = v2;
         printWildcard(v2);
    	
    }
    
    
    
    	// Genericite delimitee
    	// cas n1 : Type generique a borne superieure (upper-bounded gneric Type)
    	
    	// Ce genre de fonctionnalite existe dans 2 contextes differents : 
    	// 1 a la definition du type
    	// 2. a la declaration des variables
    	
    	// la genericite permet de restrindre 
    	// 1.1 definition du type //delimitation(raison ailleurs)
    void exp03() {
    	
    	class Data<T extends Point>  {
    		private T element; // data type parametrable generique
    	}
    	
    	//Data<String> d1 = new Data<>();
    	Data<Point> d1 = new Data<>();
    	Data<Pixel> d2 = new Data<>();

    	System.out.println(d1);
    	System.out.println(d2);
        
    	// 1.2 declaration
    	Vector<? extends Point> v1 = new Vector <Pixel>(); // legitime  type sghar mn Point ce type est delimite par point au supeieure (utilise pour parametre de methode) 
    	
    	class Buffer{
    		
    		public static void print(Vector<? extends Point> v) {
    			System.out.println(v);
    		}
    	}
    	
    	Vector<Pixel> v2 = new Vector<>();
    	Buffer.print(v2);
    }
    
    
    void exp04(){
    	//genericite delimite 
    	// cas 2 : type generique a borne inferieure (lower-bounded generic type)
    	
    	// il y a un seul contexte d'utilisation de ce genre de restriction :
    	Vector<Point> v1 = new Vector<>();
    	Vector<Pixel> v2 = new Vector<>();
    	Vector<String> v3 = new Vector<>();
    	Vector<Object> v4 = new Vector<>();
        
    	// de point lfou9 
        Vector<? super Point> v5 = v1; 
        Vector<? super Point> v6 = v4;
        
        //Vector<? super Point> v5 = v2; // Faux
        //Vector<? super Point> v5 = v3; //Faux

        v6.add(new Point()); // affecter tout ce qui est pere de point entre >=point(super Point) <=objet(extends Object)
        v6.add(new Pixel()); // affectatiion fille -> mere
    	// v6.add(""); // Faux string pas pere de Point donc pas delimite entre Point et Object
        
        
        class Buffer {
        	public  void init(Vector<? super Point> v, int size) {
        		for (int i = 0; i < size; i++) {
					v.add(new Point());
				}
        	}
        }
        
        Buffer buffer = new Buffer ();
        buffer.init(v1, 10);
        System.out.println(v1.size());
    }
    
    
    void exp05() {
    	Vector<String> letters = new Vector<String>(java.util.List.of("A", "B", "C", "D"));//list immuable envloppe avec vector
    	String s = pop(letters);
    	System.out.println("letters: " +letters);
    	System.out.println("s: " +s);
    	
    	String s1 = createObject(String.class);
    	Integer i1 = createObject(Integer.class);
    	Point p1 = createObject(Point.class);
     
        Object s2 ="20";// "Une chaine";
        System.out.println(s2.getClass().getName());
        if(s2 instanceof String) {
	        String s3 = (String)s2;
	        System.out.println("s3= "+ s3);
        }
        
                }
    
    
    	// String s3 = 
    	// transtypage(casting) pour les objets n est pas valable que dans une affec mere fille caster mere vers fille
        // l'autoboxing   // d'andurance assurer votre entiere responsabilite   le type normale passer par object 
    
    
    public <T> T pop(Vector<T> v) {
    	return v.remove(0);
    }
    
	private void printWildcard(Vector<Pixel> v) {
		System.out.println(v);
	}
	
	private void print(Vector<Point> v) {
		System.out.println(v);
	}
	
	
	public <T> T createObject(Class<T> cls) {
		try {
			return cls.getConstructor().newInstance();	
		}catch(Exception e) {
			return null;
		}
	}
	
	//resolution dynamique de type est a  la vole
	
	public static void main(String[] args) {
        new QuickReminder();	
	}

	
	
}
