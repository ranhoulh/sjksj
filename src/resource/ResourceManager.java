package resource;

import Table.Manager;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager {
    private List<Manager> managerList;

    public static ResourceManager ManagerL = new ResourceManager();

    ResourceManager(){
        this.managerList = new ArrayList<>();
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }
}
