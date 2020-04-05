package Model;


public class InHousePart extends Part {

    protected int machineId;

    public InHousePart(int id, String name, Double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int id) {
        this.machineId =id;
    }
}
