public class Boy extends Combatant {
    public Boy(String Name, int Toughness, int Wounds, String Weapon, int WeaponStrength, String Species) {
        super(Name, Toughness, Wounds, Weapon, WeaponStrength, Species);
    }

    @Override
    public void Attack(Combatant Target) {
        System.out.println(this.getName() + " blasts their " + this.getWeapon() + " at " + Target.getName());
        int BaseDamage = (this.getWeaponStrength() - Target.getToughness());
        if (BaseDamage == 0 || BaseDamage < 0) {
            System.out.print(" But their armor was too great and deflected the blow! ");

        } else {
            System.out.print(" for a total of " + BaseDamage + " damage!!!");
        }


    }
}