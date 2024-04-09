package ru.job4j.ood.examples;

public interface GeneralISP {

    BDEssence create();
    boolean add(BDEssence bdEssence);
    boolean update(BDEssence bdEssence);
    boolean delete(BDEssence bdEssence);
    BDEssence findByName(String name);
    BDEssence findById(int id);
    int returnId(String name);
    BDEssence findByFirstChar(char firstChar);
    int probabilityDistributionInterval(int firstId, int secondId);
}
