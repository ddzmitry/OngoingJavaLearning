package Model;


import Utils.Util;

public class Outsourced extends Part {
    protected  String companyName;

    public Outsourced(int id, String name, Double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public static String isPartValid(String name,double price,int stock,int min , int max, String CoName){
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
        } if(CoName == null){
            errorMessage.append("Name cant be empty");
        }
        return  errorMessage.toString();
    }
}
