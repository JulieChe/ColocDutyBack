package JavaTpoint.JavaObjectToJSON;  
import java.util.List;

import com.coloc_duty.entities.Membre;
import com.google.gson.Gson;    
public class ConvertJSON {  
	
   
    
    public static String convert(List<Membre> membres) {  
           
        
        
		return new Gson().toJson(membres);    
    }  
}  