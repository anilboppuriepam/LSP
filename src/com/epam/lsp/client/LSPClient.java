package com.epam.lsp.client;

import java.util.List;
import java.util.Scanner;

import com.epam.lsp.model.Product;
import com.epam.lsp.URHealthService.ProductService;
import com.epam.lsp.URHealthService.payment.MealCardType;
import com.epam.lsp.URHealthService.payment.PaymentRequest;
import com.epam.lsp.URHealthService.payment.PaymentResponse;
import com.epam.lsp.URHealthService.payment.PaymentService;
import com.epam.lsp.repository.IProductContext;
import com.epam.lsp.repository.IProductRepository;
import com.epam.lsp.repository.ProductContext;
import com.epam.lsp.repository.ProductRepository;

public class LSPClient {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		  IProductContext productContext = new ProductContext();
          ProductRepository productRepository = new ProductRepository(productContext);
          ProductService productService = new ProductService(productRepository);
          List<Product> products = productService.getAllProducts();
          //  Product product = products.FirstOrDefault<Product>();            

          System.out.println("********* UR Health Store - Meal Plans ***********");

          
        /*  foreach (Product product : products)
          {
              System.out.println("Meal: {0}, Name: {1}, Price: Rs.{2}, Calories: {3}", product.get, product.Name, product.Price, product.Calories);

          }*/

          System.out.println("********* ********** ***********");
          System.out.println("Choose the meal name to place order:");
          String productName = scanner.next();
 //         Product selectedProduct = products.ToList<Product>().Find(x => x.Name.Contains(productName));
          
          com.epam.lsp.model.Product selectedProduct = null;
  		
  		for(com.epam.lsp.model.Product tempProduct : products){
  			
  			 if(tempProduct.getName().equals(productName))
  				 selectedProduct = tempProduct;
  				 
  		}
  		
          System.out.printf("You have choosen meal: %s, and price is Rs.%d", selectedProduct.getName(), selectedProduct.getPrice());
          System.out.println("********* ********** ***********");

          System.out.println("Our store supports Zeta / Sodexho.");

          System.out.println("Please enter your card type to proceed for payment...");

          String cardType = scanner.nextLine();

          System.out.println("********* ********** ***********");

          PaymentRequest paymentRequest = new PaymentRequest();

          paymentRequest.setAmount(selectedProduct.getPrice());

          if(cardType == "Sodexho")
              paymentRequest.setCardType(MealCardType.SODEX);
          else if (cardType == "Zeta")
              paymentRequest.setCardType(MealCardType.ZETA);

          paymentRequest.setPaymentTransactionId( "URHealth") ;

          PaymentService paymentService = new PaymentService();
          PaymentResponse paymentResponse = paymentService.pay(paymentRequest);

         String status = ((paymentResponse.isSucces()) ? "Thank you for payment! Your transaction is successful.  You'll receive URHealth meal pack in 1 hour." : "Your card is declined, please refer your tranaction id in future communication - "+paymentRequest.getPaymentTransactionId());


          System.out.println(status + " \n Transaction message: " + paymentResponse.getMessage());

          scanner.next();
	}

}
