import ru.ifmo.se.pokemon.*;

public class mainWork {
    public static void main(String[] args) {
        Battle b = new Battle();

        Aerodactyl p1 = new Aerodactyl("Fan Of GuAP", 1);
        Mudbray p2 = new Mudbray("КТшник", 1);
        Mudsdale p3 = new Mudsdale("ИКТшник", 1);
        Flabebe p4 = new Flabebe("ВТшник", 1);
        Floette p5 = new Floette("БизнесИнформатик", 1);
        Florges p6 = new Florges("Пижон", 1);

        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}

class Flabebe extends Pokemon{
    public Flabebe(String name, int level) {
        super(name, level);
        super.setType(Type.FAIRY);
        super.setStats(44, 38, 39, 61, 79, 42);
        super.setMove(new Confide(), new Facade());
    }
}

class Floette extends Pokemon{
    public Floette(String name, int level) {
        super(name, level);
        super.setType(Type.FAIRY);
        super.setStats(54, 45, 47, 75, 98, 52);
        super.setMove(new Confide(), new Facade(), new IceBeam());
    }
}

class Florges extends Pokemon{
    public Florges(String name, int level) {
        super(name, level);
        super.setType(Type.FAIRY);
        super.setStats(78, 65, 68, 112, 154, 75);
        super.setMove(new Confide(), new Facade(), new IceBeam(), new SleepPowder());
    }
}

class Mudbray extends Pokemon{
    public Mudbray(String name, int level) {
        super(name, level);
        super.setType(Type.GROUND);
        super.setStats(70, 100, 70, 45, 55, 45);
        super.setMove(new Confide(), new IceBeam(), new Rest());
    }
}

class Mudsdale extends Pokemon{
    public Mudsdale(String name, int level) {
        super(name, level);
        super.setType(Type.GROUND);
        super.setStats(100, 125, 100, 55, 85, 35);
        super.setMove(new Confide(), new IceBeam(), new Rest(), new Shadow_Claw());
    }
}

class Aerodactyl extends Pokemon{
    public Aerodactyl(String name, int level) {
        super(name, level);
        super.setType(Type.ROCK, Type.FLYING);
        super.setStats(80, 105, 65, 60, 75, 130);
        super.setMove(new Swift(), new Sludge_Bomb(), new Supersonic(), new Leech_Life());
    }
}

///////////////////////////////

class Confide extends StatusMove{
    public Confide() {
        super(Type.NORMAL, 0, 0);
    }
    @Override
    protected java.lang.String describe(){
        return "использует Confide";
    }
    @Override
    protected void applyOppEffects(Pokemon pokEnemy) {
        Effect atkEff = new Effect().stat(Stat.SPECIAL_ATTACK, -1);
        pokEnemy.addEffect(atkEff);
    }
}

class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }
    @Override
    protected java.lang.String describe(){
        return "использует Facade";
    }
    @Override
    protected void applySelfEffects(Pokemon pokSelf) {
        if(pokSelf.getCondition() == Status.BURN ||
                pokSelf.getCondition() == Status.POISON ||
                pokSelf.getCondition() == Status.PARALYZE) {
            Effect atkEff = new Effect().stat(Stat.ATTACK, (int)(pokSelf.getStat(Stat.ATTACK)*2));
            pokSelf.addEffect(atkEff);
        }
    }
}

class IceBeam extends SpecialMove {
    public IceBeam() {
        super(Type.ICE, 90, 100);
    }
    @Override
    protected java.lang.String describe() {
        return "использует IceBeam";
    }
    @Override
    protected void applyOppEffects(Pokemon pokEnemy) {
        if (Math.random() < 0.1){
            Effect.freeze(pokEnemy);
        }
    }
}

class SleepPowder extends StatusMove {
    public SleepPowder() {
        super(Type.GRASS, 0, 75);
    }
    @Override
    protected java.lang.String describe() {
        return "использует SleepPowder";
    }
    @Override
    protected void applyOppEffects(Pokemon pokEnemy) {
        Effect.sleep(pokEnemy);
    }
}

class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Rest";
    }
    @Override
    protected void applySelfEffects(Pokemon pokSelf) {
        Effect atkEff = new Effect().turns(2).stat(Stat.HP, (int)pokSelf.getStat(Stat.HP));
        pokSelf.addEffect(atkEff);
    }
}

class Shadow_Claw extends PhysicalMove {
    public Shadow_Claw() {
        super(Type.GHOST, 70, 100);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Shadow_Claw";
    }
    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def){
        double k = Math.random();
        if(k <= 0.125) return 2;
        else return 1;
    }
}

class Swift extends SpecialMove {
    public Swift() {
        super(Type.NORMAL, 60, Math.exp(1000));
    }
    @Override
    protected java.lang.String describe() {
        return "использует Swift";
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        Effect atkEff = new Effect().turns(1);
        p.addEffect(atkEff);
        p.setMod(Stat.EVASION, 0);
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        Effect atkEff = new Effect().turns(1).stat(Stat.ACCURACY, 100);
        p.addEffect(atkEff);
    }
}
class Sludge_Bomb extends SpecialMove {
    public Sludge_Bomb() {
        super(Type.POISON, 90, 100);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Sludge_Bomb";
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() < 0.3){
            Effect.poison(p);
        }
    }
}

class Supersonic extends StatusMove {
    public Supersonic() {
        super(Type.NORMAL, 0, 55);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Supersonic";
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        p.confuse();
    }
}

class Leech_Life extends PhysicalMove {
    public Leech_Life() {
        super(Type.BUG, 80, 100);
    }
    @Override
    protected java.lang.String describe() {
        return "использует Leech_Life";
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        Effect atkEff = new Effect().stat(Stat.HP, +(int)((p.getStat(Stat.HP) - p.getHP())/2));
        p.addEffect(atkEff);
    }
}
