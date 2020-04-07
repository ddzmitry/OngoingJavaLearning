package Model;

public abstract class Part {
    protected final int PartID;
    protected final String PartName;
    protected final Double PartPrice;
    protected final int PartStock;
    protected final int PartMin;
    protected final int PartMax;

    protected Part(int partID, String partName, Double partPrice, int partStock, int partMin, int partMax) {
        PartID = partID;
        PartName = partName;
        PartPrice = partPrice;
        PartStock = partStock;
        PartMin = partMin;
        PartMax = partMax;
    }

    public int getPartID() {
        return PartID;
    }

    public String getPartName() {
        return PartName;
    }

    public Double getPartPrice() {
        return PartPrice;
    }

    public int getPartStock() {
        return PartStock;
    }

    public int getPartMin() {
        return PartMin;
    }

    public int getPartMax() {
        return PartMax;
    }

/// Validation

    public static String isPartValid(String name,double price,int stock,int min , int max){
        StringBuilder errorMessage;
        errorMessage = new StringBuilder();

        if(name.isEmpty()){
            errorMessage.append("The name field is REQUIRED.\n");
        } else if( price <= 0){
            errorMessage.append("Price cannot be negative or zero.\n");
        }else if(stock <= 0){
            errorMessage.append("Stock cannot be negative or zero.\n");
        }else if(max < min){
            errorMessage.append("Max value must be greater or equal min value.\n");
        } if (stock < min || stock > max){
            errorMessage.append("Stock value must be between Min and Max.\n");
        }
        return  errorMessage.toString();
    }



}
