public class CustomerTest {

    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.displayCustomerInfo();
        Customer customer2 = new Customer();
        customer2.customerID = 402845908;
        customer2.emailAddress = "andresrodriguez@gamil.com";
        customer2.name = "Andres Rodriguez";
        customer2.displayCustomerInfo();
    }
}