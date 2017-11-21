package util;

import java.util.Random;

import jpa.User;
import jpa.test.entities.User2;

public class Util {
	
	
	public static User getRandomUser() {
        String[] name ={"Arek", "Garek", "Wania", "Ziuta", "Jewop", "Maniek", "Johny", "Filut", "Misiek", "Genowefa", "Moniek", "Fluffy" };
        String[] surname ={"Kowalski", "Lenon", "Mongo", "Osio�ek", "Palant", "Ole", "Ktoto", "Małpa", "Pigwa", "Serio", "Mongo", "Nocoty"};
        
        Random random = new Random();
        
        return new User(name[random.nextInt(name.length)], surname[random.nextInt(surname.length)]);
    }
	
	public static User2 getRandomUser2() {
        String[] name ={"Arek", "Garek", "Wania", "Ziuta", "Jewop", "Maniek", "Johny", "Filut", "Misiek", "Genowefa", "Moniek", "Fluffy" };
        String[] surname ={"Kowalski", "Lenon", "Mongo", "Osio�ek", "Palant", "Ole", "Ktoto", "Małpa", "Pigwa", "Serio", "Mongo", "Nocoty"};
        
        Random random = new Random();
        
        return new User2(name[random.nextInt(name.length)], surname[random.nextInt(surname.length)]);
    }
	
}
