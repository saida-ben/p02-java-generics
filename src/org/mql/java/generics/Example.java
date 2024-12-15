package org.mql.java.generics;

public class Example {

	public Example() {
		exp04();
	}
	
	void exp01() {
			
		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(20);
		l1.add(120);
		l1.add(130);
		l1.add(30);

		System.out.println(l1.size());
	    System.out.println("Contains 120: " + l1.contains(120));  // Output: true
	    System.out.println("Contains 100: " + l1.contains(100));
	}
	
	void exp02() {
		
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(20);
		l1.add(120);
		l1.add(130);
		l1.add(30);
	    for(Integer element : l1) {
			System.out.println(element);

	    }
	}
	
	void exp03() {
	        Vector<Integer> vector = new Vector<>();

	        // Ajout d'éléments
	        vector.add(10);
	        vector.add(20);
	        vector.add(30);

	        // Affichage de la taille
	        System.out.println("Size: " + vector.size());

	        // Accès aux éléments
	        System.out.println("Element at index 1: " + vector.get(1));

	        // Modification d'un élément
	        vector.set(1, 25);
	        System.out.println("Updated element at index 1: " + vector.get(1));

	        // Suppression d'un élément
	        System.out.println("Removed element: " + vector.remove(1));
	        System.out.println("Size after removal: " + vector.size());

	        // Vérification de la présence
	        System.out.println("Contains 30: " + vector.contains(30));
	        System.out.println("Contains 25: " + vector.contains(25));

	        // Itération
	        System.out.println("Iterating over elements:");
	        for (Integer value : vector) {
	            System.out.println(value);
	        }

	        // Vider le vecteur
	        vector.clear();
	        System.out.println("Is empty after clear: " + vector.isEmpty());
	    

	}
	
	private void exp04() {
        Set<Integer> set = new Set<>();
        set.add(20);
        set.add(120);
        set.add(130);
        set.add(30);

        System.out.println("Size: " + set.size());
        System.out.println("Contains 120: " + set.contains(120));  // Output: true
        System.out.println("Contains 100: " + set.contains(100));  // Output: false
        System.out.println("Set contents: " + set);  // Affiche les éléments du Set
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Example();
	}

}
