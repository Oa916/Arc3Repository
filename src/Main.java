import java.util.ArrayList;
import java.util.Scanner;

public static void main(String[] args) throws IOException {

ArrayList<Combatant> roster = new ArrayList<>();
roster.add(new BossNob("BossNob","Guz", 2, 2,"Kombi-weapon", 4,"Ork", "Power Klaw" , 9));
roster.add(new Boy("Boy","Grunt", 2,2, "Slugga", 4,"Ork"));
roster.add(new SpaceMarineLieutenant("SpaceMarineLieutenant","Lieutenant John", 4,4, "Heavy bolt pistol", 4, "Human-SpaceMarine", "Power fist", 8));


for (Combatant c : roster) {
    System.out.println(c.toCsv());
}
    FileWriter writer = new FileWriter("save.txt");
    for (Combatant c : roster) {
        writer.write(c.toCsv() + "\n");
    }
    writer.close();
    try {
        Scanner fileScanner = new Scanner(new File("save.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");
            // ["Guz","2","2" ,"Kombi-weapon","4","Ork"]
            String type = parts[0];
            String name = parts[1];
            int toughness = Integer.parseInt(parts[2]);
            int wounds = Integer.parseInt(parts[3]);
            String weapon = parts[4];
            int weaponstrength = Integer.parseInt(parts[5]);
            String species = parts[6];




            if (type.equals("BossNob")) {
                String closeQuartersWeapon = parts[7];
                int closeQuartersWeaponStrength = Integer.parseInt(parts[8]);

                roster.add(new BossNob(type,name,toughness,wounds,weapon,weaponstrength,species,closeQuartersWeapon,closeQuartersWeaponStrength));
            }

            if (type.equals("SpaceMarineLieutenant")) {
                String closeQuartersWeapon = parts[7];
                int closeQuartersWeaponStrength = Integer.parseInt(parts[8]);
                roster.add(new SpaceMarineLieutenant(type,name,toughness,wounds,weapon,weaponstrength,species,closeQuartersWeapon,closeQuartersWeaponStrength));

            }


        }
        fileScanner.close();
    } catch (FileNotFoundException e) {
        System.out.print("save.txt file does not exist!");
    }


}