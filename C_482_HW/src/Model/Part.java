package Model;

public abstract class Part {
    // Definition of fields
    protected final int id;
    protected final String name;
    protected final Double price;
    protected final int stock;
    protected final int min;
    protected final int max;

    protected Part(int id, String name, Double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
/// Validation

    public static String isPartValid(String name,double price,int stock,int min , int max){
        StringBuilder errorMessage;
        errorMessage = new StringBuilder();

        if(name == null){
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
