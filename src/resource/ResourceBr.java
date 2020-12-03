package resource;

import Table.Br;

import java.util.ArrayList;
import java.util.List;

public class ResourceBr {
    private List<Br> brList;

    public static ResourceBr BrL = new ResourceBr();

    ResourceBr(){
        this.brList = new ArrayList<>();
    }

    public List<Br> getBrList() {
        return brList;
    }

    public void setBrList(List<Br> BrList) {
        this.brList = brList;
    }
}
