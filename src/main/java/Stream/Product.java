package Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	private int pId;
	private String pName;
	private float pPrice;
}
