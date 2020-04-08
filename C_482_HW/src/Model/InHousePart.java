package Model;


import Utils.Util;

public class InHousePart extends Part {

    protected int machineId;

    public InHousePart(int id, String name, Double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(int id) {
        this.machineId =id;
    }

    public static String isPartValid(String name,double price,int stock,int min , int max, String MachineId){
        StringBuilder errorMessage;
        errorMessage = new StringBuilder();

        if(name == null){
            errorMessage.append("The name field is REQUIRED.\n");
        }else if(stock <= 0){
            errorMessage.append("Stock cannot be negative or zero.\n");
        }
        else if( price <= 0){
            errorMessage.append("Price cannot be negative or zero.\n");
        }else if(max < min){
            errorMessage.append("Max value must be greater or equal min value.\n");
        } if (stock < min || stock > max){
            errorMessage.append("Stock value must be between Min and Max.\n");
        } if(!Util.isNumeric(MachineId) || MachineId == null ){
            errorMessage.append("Machine ID Must be  Numeric");
        }
        return  errorMessage.toString();
    }
}
