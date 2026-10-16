public class Product {
    private String productName;
    private String productCode;
    private double price;
    private int stockQuantity;

    public Product(String productName, String productCode, double price, int stockQuantity) {
        this.productName = productName;
        this.productCode = productCode;
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price must be greater than 0.");
        }
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) {
            this.stockQuantity = stockQuantity;
        } else {
            System.out.println("Stock quantity cannot be negative.");
        }
    }

    public void displayProduct() {
        System.out.println("------------------------------------");
        System.out.println("Name: " + productName);
        System.out.println("Code: " + productCode);
        System.out.printf("Price: %.2f%n", price);
        System.out.println("Stock: " + stockQuantity);
    }
}