public class CadianShockTrooper extends Combatant {
    public CadianShockTrooper(String Name, int Toughness,int Wounds,String Weapon,int WeaponStrength ,String Species) {
        super(Name,Toughness,Wounds,Weapon,WeaponStrength ,Species);
    }

    @Override
    public void Attack(Combatant Target) {
        System.out.println(this.getName() + " scorches " + Target.getName() + " with their " + this.getWeapon());
        int BaseDamage = (this.getWeaponStrength() - Target.getToughness());
        System.out.print(" for a total of " + BaseDamage + " damage!!!");
    }


}