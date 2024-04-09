package ru.job4j.ood.examples;

public abstract class CRUDISP implements GeneralISP {

    @Override
    public BDEssence create() {
        return null;
    }

    @Override
    public boolean add(BDEssence bdEssence) {
        return false;
    }

    @Override
    public boolean update(BDEssence bdEssence) {
        return false;
    }

    @Override
    public boolean delete(BDEssence bdEssence) {
        return false;
    }

    @Override
    public BDEssence findByName(String name) {
        return null;
    }

    @Override
    public BDEssence findById(int id) {
        return null;
    }

    @Override
    public int returnId(String name) {
        return 0;
    }

    @Override
    public BDEssence findByFirstChar(char firstChar) {
        return null;
    }
}
