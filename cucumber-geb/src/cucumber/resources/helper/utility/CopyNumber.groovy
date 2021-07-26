package helper.utility

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Procedimento destinado a cópia de dados numéricos
 * 
 * @author Edgar Machado Barbosa de Melo (emelo@cpqd.com.br)
 */

public class CopyNumber {

	public String getOnlyNumber(String value) {
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(value);
		StringBuffer result = new StringBuffer();
			
		while (m.find()) {
			  result.append(m.group());
		}
			
		return result.toString();
	}
}