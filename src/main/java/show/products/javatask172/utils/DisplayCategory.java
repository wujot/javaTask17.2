package show.products.javatask172.utils;

import show.products.javatask172.model.Product;
import show.products.javatask172.model.Products;

import java.util.ArrayList;
import java.util.List;

public class DisplayCategory {

    // method gets list of appropriate category
    public static List<Product> displayProductByCategory(List<Product> products, String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product: products) {
            if (product.getCategory().equals(category))
                productsByCategory.add(product);
        }
        return productsByCategory;
    }

    // method calculate sum of products prices
    public static double sumOfPrices(List<Product> products) {
        double price = 0;
        double sum = 0;
        for (Product product : products) {
            price = Double.parseDouble(product.getPrice());
            sum += price;
        }
        return sum;
    }

    // method display appropriate list of products as a html table
    public static String displayResult(List<Product> listOfProducts, String category) {
        StringBuilder stringBuilder = new StringBuilder();
        String row;
        double sum = 0;
        sum = DisplayCategory.sumOfPrices(listOfProducts);
        String tableTitle;
        if (category == null) {
            tableTitle = "ALL Products";
        } else {
            tableTitle = category;
        }
        // create row table of product
        for(Product product:listOfProducts){
            row =     "<tr>" +
                    "<td>" + product.getName() + "</td>" +
                    "<td>" + product.getCategory() + "</td>" +
                    "<td>" + product.getPrice() + "</td>" +
                    "</tr>";
            stringBuilder.append(row);
        }
        return  "<style> " +
                "@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100); " +
                "body {\n" +
                "  background-color: white;\n" +
                "  font-family: \"Roboto\", helvetica, arial, sans-serif;\n" +
                "  font-size: 16px;\n" +
                "  font-weight: 400;\n" +
                "  text-rendering: optimizeLegibility;\n" +
                "}" +
                "h3 {\n" +
                "   color: black;\n" +
                "   font-size: 30px;\n" +
                "   font-weight: 400;\n" +
                "   font-style:normal;\n" +
                "   font-family: \"Roboto\", helvetica, arial, sans-serif;\n" +
                "   text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);\n" +
                "   text-transform:uppercase;\n" +
                "}" +
                "table " +
                "{ border-collapse: collapse; width: 100%; font-family: \"Roboto\", helvetica, arial, sans-serif;\n" +
                "  font-size: 16px; font-weight: 400; text-rendering: optimizeLegibility;} " +
                "th, td " +
                "{ text-align: left; padding: 8px; }" +
                "tr:nth-child(even){background-color: #f2f2f2} " +
                "th { color:#D5DDE5;;\n" +
                "  background:#1b1e24;\n" +
                "  border-bottom:4px solid #9ea7af;\n" +
                "  border-right: 1px solid #343a45;\n" +
                "  font-size:23px;\n" +
                "  font-weight: 100;\n" +
                "  padding:24px;\n" +
                "  text-align:left;\n" +
                "  text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);\n" +
                "  vertical-align:middle;} " +
                "tr {\n" +
                "  border-top: 1px solid #C1C3D1;\n" +
                "  border-bottom-: 1px solid #C1C3D1;\n" +
                "  color:#666B85;\n" +
                "  font-size:16px;\n" +
                "  font-weight:normal;\n" +
                "  text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1);\n" +
                "}" +
                "tr:hover td {\n" +
                "  background:#4E5066;\n" +
                "  color:#FFFFFF;\n" +
                "  border-top: 1px solid #22262e;\n" +
                "}" +
                "td {\n" +
                "  background:#FFFFFF;\n" +
                "  padding:20px;\n" +
                "  text-align:left;\n" +
                "  vertical-align:middle;\n" +
                "  font-weight:300;\n" +
                "  font-size:18px;\n" +
                "  text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);\n" +
                "  border-right: 1px solid #C1C3D1;\n" +
                "}" +
                "</style>" +
                "<h3>" + tableTitle + "</h3>" +
                "<table> <tr> <th>Name:</th> <th>Category</th> <th>Price</th></tr>" +
                stringBuilder +
                "<tr><td colspan=\"2\">Total: </td><td>" + sum + "</td></tr>" +
                "</table>";
    }
}
