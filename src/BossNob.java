

public class BossNob extends Combatant implements Combatant.MeleeAttack {
    private String CloseQuartersWeapon;
    private int CloseQuartersWeaponStrength;
    public BossNob(String Name, int Toughness,int Wounds,String Weapon,int WeaponStrength ,String Species,String CloseQuartersWeapon, int CloseQuartersWeaponStrength) {
        super(Name,Toughness,Wounds,Weapon,WeaponStrength,Species);
        this.CloseQuartersWeapon = CloseQuartersWeapon;
        this.CloseQuartersWeaponStrength = CloseQuartersWeaponStrength;

    }
    public String getCloseQuartersWeapon() {return CloseQuartersWeapon;}
    public int getCloseQuartersWeaponStrength() {return CloseQuartersWeaponStrength;}


    @Override
    public void UseSpecialMelee(Combatant Target) {
        System.out.println(this.getName() + " Crushes " + Target.getName() + " wither their " + this.getCloseQuartersWeapon());
        int MeleeBaseDamage = (this.CloseQuartersWeaponStrength - Target.getToughness());
        System.out.print(" for a total of " + MeleeBaseDamage + " damage!!!");
    }

    @Override
    public void Attack(Combatant Target) {
        System.out.println(this.getName() + " blasts their " + this.getWeapon() + " at " + Target.getName());
        int BaseDamage = (this.getWeaponStrength() - Target.getToughness());
        if (BaseDamage == 0 || BaseDamage < 0) {
            System.out.print(" But their armor was too great and deflected the blow! ");

        }
        else {
            System.out.print(" for a total of " + BaseDamage + " damage!!!");
        }
    }
}