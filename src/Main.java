import java.util.ArrayList;

public static void main(String[] args) {

ArrayList<Combatant> roster = new ArrayList<>();
roster.add(new BossNob("Guz", 2, 2,"Kombi-weapon", 4,"Ork", "Power Klaw" , 9));
roster.add(new Boy("Grunt", 2,2, "Slugga", 4,"Ork"));
roster.add(new SpaceMarineLieutenant("Lieutenant John", 4,4, "Heavy bolt pistol", 4, "Human-SpaceMarine", "Power fist", 8));
roster.add(new SpaceMarine("Marine David",4,2,"Bolt Rifle",5,"Human-SpaceMarine"));


for (Combatant c : roster) {
    System.out.println(c);
    c.Attack(c);
}


}