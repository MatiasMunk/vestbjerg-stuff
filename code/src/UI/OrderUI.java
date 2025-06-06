package UI;

import Controllers.*;
import Model.*;

import java.util.Scanner;

public class OrderUI {

    private static OrderController orderController;
    private static CustomerController customerController;
    private static ProductController productController;
    private static Scanner scanner;

    public static void main(String[] args) {

        // Initialize controllers and scanner
        scanner = new Scanner(System.in);
        customerController = new CustomerController();
        productController = new ProductController();
        orderController = new OrderController(customerController, productController);

        // Preload some products
        preloadProducts();

        boolean running = true;

        while (running) {
            System.out.println("\n=== ERP Order System ===");
            System.out.println("1. Create new order");
            System.out.println("2. Add product to current order");
            System.out.println("3. Remove product from order");
            System.out.println("4. Apply discount to order");
            System.out.println("5. View current order");
            System.out.println("6. Finalize order");
            System.out.println("7. Cancel order");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> createOrder();
                case "2" -> addProductToOrder();
                case "3" -> removeProductFromOrder();
                case "4" -> applyDiscountToOrder();
                case "5" -> viewCurrentOrder();
                case "6" -> finalizeOrder();
                case "7" -> cancelOrder();
                case "0" -> running = false;
                default -> System.out.println("Invalid option, please try again.");
            }
        }

        System.out.println("Exiting ERP System.");
    }

    private static void preloadProducts() {
        productController.addProduct(new Product("Hammer", "ACME", "H100", "1111", 10, 100, "Heavy hammer", "Tools", "SKU001", 79.95, 0, 49.95, 59.95));
        productController.addProduct(new Product("Cement Bag", "BuildWell", "C250", "2222", 20, 500, "50kg Cement", "Materials", "SKU002", 149.00, 0, 89.50, 99.95));
        productController.addProduct(new Product("Screw Pack", "ScrewIt", "S300", "3333", 30, 300, "200 screws", "Hardware", "SKU003", 35.00, 0, 15.00, 25.00));
    }

    private static void createOrder() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        Customer customer = customerController.findCustomerByName(name);
        if (customer == null) {
            System.out.println("Customer not found. Creating new customer.");
            customer = new Customer(name);
            customerController.addCustomer(customer);
        }

        if (orderController.createOrder(customer.getId())) {
            System.out.println("New order created for " + customer.getName());
        } else {
            System.out.println("Error creating order.");
        }
    }

    private static void addProductToOrder() {
        System.out.print("Enter product ID to add: ");
        int productId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        if (orderController.addProduct(productId, qty)) {
            System.out.println("Product added to order.");
        } else {
            System.out.println("Error adding product.");
        }
    }

    private static void removeProductFromOrder() {
        System.out.print("Enter product ID to remove: ");
        int productId = Integer.parseInt(scanner.nextLine());

        if (orderController.removeProduct(productId)) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Could not remove product.");
        }
    }

    private static void applyDiscountToOrder() {
        System.out.print("Enter discount percentage (0-100): ");
        double percent = Double.parseDouble(scanner.nextLine()) / 100.0;

        orderController.applyDiscount(percent);
        System.out.println("Discount applied.");
    }

    private static void viewCurrentOrder() {
        Order current = orderController.getCurrentOrder();
        if (current == null) {
            System.out.println("No active order.");
            return;
        }

        System.out.println("\n--- Current Order ---");
        System.out.println("Customer: " + current.getCustomer().getName());
        for (OrderLine line : current.getOrderLines()) {
            System.out.println(line);
        }
        System.out.println("Total: $" + current.calculateTotal());
    }

    private static void finalizeOrder() {
        if (orderController.validateOrder()) {
            Invoice invoice = orderController.finishOrder();
            System.out.println("Order finalized. Invoice generated:");
            System.out.println("Order ID: " + invoice.getOrder().getOrderId());
            System.out.println("Customer: " + invoice.getOrder().getCustomer().getName());
            System.out.println("Total: $" + invoice.getOrder().calculateTotal());
        } else {
            System.out.println("Cannot finalize. Order is invalid.");
        }
    }

    private static void cancelOrder() {
        orderController.cancelOrder();
        System.out.println("Order canceled.");
    }
}
