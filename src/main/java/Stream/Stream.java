package Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {
	public static void main( String[] args )
    {
        List<Product> plist = new ArrayList<Product>();
        plist.add(new Product(1,"Samsung",25000f));
        plist.add(new Product(2,"Nokia",20000f));
        plist.add(new Product(3,"Apple",30000f));
        plist.add(new Product(4,"Sony",22000f));
        plist.add(new Product(5,"Mi",12000f));
        plist.add(new Product(6,"Huawei",15000f));
        
        //using stream printing list without using for loop  or iterator 
        plist.stream().forEach(product->System.out.println(product));
        
        //compact approach for filtering data
        plist.stream().filter(product->product.getPPrice()==30000).forEach(product->System.out.println(product.getPName()));
        
        //filtering data and also convert into set
        List<Float> plist1 = plist.stream()
        		.filter(p->p.getPPrice()>20000) //filtering data
        		.map(p->p.getPPrice()) //fetching price
        		.collect(Collectors.toList()); // collecting as list
        System.out.println(plist1);
        
        // More precise code - sum of prices
        Float plist2 = plist.stream().map(p->p.getPPrice()).reduce(0.0f,Float::sum); //accumulating price, by referring method of float class
        System.out.println(plist2);
        
        // Using Collectors's method - sum of prices.
        double plist3 = plist.stream().collect(Collectors.summingDouble(p->p.getPPrice()));
        System.out.println(plist3);
        
        // count number of product based on filter
        long count = plist.stream().filter(p->p.getPPrice()>15000).count();
        System.out.println("Total Number of Filtered Product is: "+count);
        
        // count total number of product
        long count1 = plist.stream().count();
        System.out.println("Total Number of Product is: "+count1);
        
        Product Max = plist.stream().max((p1,p2)->p1.getPPrice()>p2.getPPrice()?1:-1).get();
        Product Min = plist.stream().max((p1,p2)->p1.getPPrice()<p2.getPPrice()?1:-1).get();
        System.out.println(Max.getPName() + " has highest Price of Phone And Price is: "+Max.getPPrice());
        System.out.println(Min.getPName() + " has lowest Price of Phone And Price is: "+Min.getPPrice());
    }
}
