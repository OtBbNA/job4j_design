package ru.job4j.generics;

public class Role extends Base {

    private final String rolename;
    private final int contractDuration;

    public Role(String id, String rolename, int contractDuration) {
        super(id);
        this.rolename = rolename;
        this.contractDuration = contractDuration;
    }

    public String getRolename() {
        return rolename;
    }

    public int getContractDuration() {
        return contractDuration;
    }
}
