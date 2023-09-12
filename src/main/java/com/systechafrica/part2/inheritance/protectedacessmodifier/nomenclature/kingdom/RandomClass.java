package com.systechafrica.part2.inheritance.protectedacessmodifier.nomenclature.kingdom;


public class RandomClass {
    // the protected modifier allows access inside the same package but inside the subclasses
    public void sample(){
        Kingdom kingdom = new Kingdom();

        kingdom.randomString="Martin Mabera";
    }
}
